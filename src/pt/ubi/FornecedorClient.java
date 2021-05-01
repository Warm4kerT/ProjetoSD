package pt.ubi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class FornecedorClient {

    public static void main(String[] argv) {
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
            //invoke method on server object
            Date d = myServerObject.getDate();
            System.out.println("Date on server is " + d);
            menu(myServerObject);
        }catch(MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Exception occured: " + e);
            System.exit(0);
        }

        System.out.println("RMI connection successful");
    }

    public static void registar(){

    }

    public static void menu(FornecedorInterface serverObject) throws RemoteException{
        int option = 20;

        while(option != 0){
            System.out.println("------Menu------\n" +
                    "1-Listar artigos\n"+
                    "2-Registo de artigo\n" +
                    "3-Entrada de artigos\n" +
                    "4-Eliminar artigo\n" +
                    "5-Consultar vendas\n");

            option = ler.umInt();
           // Artigos aux = new Artigos(name,Categoria,Desporto,Marca,preco,stock);
            switch (option){
                case 1:
                    for(Artigos aux: serverObject.getArtigos()){
                        System.out.println(aux);
                    }
                    break;

                case 2:
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
                    Artigos aux = new Artigos(nome, categoria, desporto, marca, preco, stock);
                    serverObject.addArtigo(aux);
                    System.out.println("Registado");

                    break;

                case 3:
                    int addstock = ler.umInt();
                    System.out.println("Insira o nome do artigo ao qual deseja adicionar stock");
                    if(serverObject.ProcurarArtigo(ler.umaString())==0) {
                        System.out.println("Indique a quantidade a adicionar");
                        aux.setStock(aux.getStock() + addstock);
                        System.out.println("Stock adicionado");
                    }
                    else
                        System.out.println("Artigo não encontrado");
                    break;

                case 4:
                    System.out.println("Insira o nome do artigo que deseja eliminar");
                    if(serverObject.ProcurarArtigo(ler.umaString())==0) {
                        serverObject.removerArtigo(aux);
                        System.out.println("Artigo eliminado");
                    }
                    else
                        System.out.println("Artigo não encontrado");
                    break;

                case 5:
                    System.out.println("Vendas:\n");

                    break;


                case 0:
                    serverObject.escreverArtigos();
                    break;
            }
        }
    }
}

