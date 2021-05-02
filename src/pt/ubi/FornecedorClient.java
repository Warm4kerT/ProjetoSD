package pt.ubi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class FornecedorClient {

    public static void main(String[] argv) {

        //Ligação ao servidor
        String serverName = "";
        System.setSecurityManager(new SecurityManager());
        if (argv.length != 1) {
            try {
                serverName = java.net.InetAddress.getLocalHost().getHostName();
            }catch(java.net.UnknownHostException e) {
                e.printStackTrace();
            }
        }else {
            serverName = argv[0];
        }

        if (serverName.equals( "") ) {
            System.out.println("usage: java RMIClient < host running RMI server>");
            System.exit(0);
        }

        try {
            //bind server object to object in client
            FornecedorInterface myServerObject =
                    (FornecedorInterface) Naming.lookup("//"+serverName+"/Fornecedor");

            ServerInterface server = (ServerInterface) Naming.lookup("Server");
            //invoke method on server object
            Date d = myServerObject.getDate();
            System.out.println("Date on server is " + d);
            menu(myServerObject,server);
        }catch(MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Exception occured: " + e);
            System.exit(0);
        }

        System.out.println("RMI connection successful");
    }

    //menus do cliente do fornecedor
    public static void menu(FornecedorInterface serverObject, ServerInterface server) throws RemoteException{
        int option = 20;
        int option2 = 20;

        while(option != 0){

            if(server.getMessage()!=null){
                System.out.println("\n\nFalta stock de: " + server.getMessage());
                server.resetMessage();
            }

            System.out.println("------Menu------\n" +
                    "1-Listar artigos\n"+
                    "2-Registo de artigo\n" +
                    "3-Entrada de artigos\n" +
                    "4-Eliminar artigo\n" +
                    "5-Consultar Compras\n\n");

            option = ler.umInt();
            Artigos search  = new Artigos();
            Artigos add;
            int size;
            int addstock;

            switch (option){
                case 1:   //Listar artigos
                    for(Artigos aux: serverObject.getArtigos()){
                        System.out.println(aux);
                    }
                    break;

                case 2:   //Registo de artigo
                    System.out.println("Nome: ");
                    String nome = ler.umaString();
                    System.out.println("Categoria: ");
                    String categoria = ler.umaString();
                    System.out.println("Marca: ");
                    String marca = ler.umaString();
                    System.out.println("Desporto: ");
                    String desporto = ler.umaString();
                    System.out.println("Preço: ");
                    float preco = ler.umFloat();
                    System.out.println("Stock: ");
                    int stock = ler.umInt();
                    add = new Artigos(nome, categoria, desporto, marca, preco, 0);
                    serverObject.addArtigo(add);
                    serverObject.addCompra(add, stock);
                    System.out.println("Registado");
                    serverObject.escreverArtigos();
                    serverObject.escreverCompras();
                    break;

                case 3:   //Entrada de artigos
                    System.out.println("Insira o nome do artigo ao qual deseja adicionar stock");
                    search = serverObject.ProcurarArtigo(ler.umaString());
                    size = serverObject.getCompras(1).size();
                    if(!search.equals(new Artigos())) {
                        System.out.println("Indique a quantidade a adicionar");
                        addstock = ler.umInt();
                        if(size == serverObject.addCompra(search,addstock)){
                            System.out.println("Não Adicionado");
                        }else{
                            System.out.println("Stock Adicionado");
                        }
                        serverObject.escreverArtigos();
                        serverObject.escreverCompras();
                    }
                    else
                        System.out.println("Artigo não encontrado");
                    break;

                case 4:   //Eliminar artigo
                    System.out.println("Insira o nome do artigo que deseja eliminar");
                    search = serverObject.ProcurarArtigo(ler.umaString());
                    if(!search.equals(new Artigos())) {
                        serverObject.removerArtigo(search.getNome());
                        System.out.println("Artigo eliminado");
                        serverObject.escreverArtigos();
                    }
                    else
                        System.out.println("Artigo não encontrado");
                    break;

                case 5:   //Consultar Compras
                    System.out.println("Compras:\n");
                    System.out.println("1- Por Nome\n2- Por Data\n3- Por Quantidade\n");
                    option2 = ler.umInt();
                    System.out.println(serverObject.getCompras(option2));
                    break;

                case 0:
                    break;
            }
       }
    }
}

