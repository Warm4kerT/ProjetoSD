package pt.ubi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class VendedorClient {
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
            VendedorInterface myServerObject =
                    (VendedorInterface) Naming.lookup("//"+serverName+"/Vendedor");
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

    public static void menu(VendedorInterface serverObject) throws RemoteException{
        int option = 20;
        int option2 = 20;

        while(option != 0){
            System.out.println("------Menu------\n" +
                    "1-Listar Artigos\n" +
                    "2-Vender\n" +
                    "3-Número de acessos\n" +
                    "4-Procurar por nome\n" +
                    "5-Listar Vendas");

            option = ler.umInt();

            Artigos search;
            int quantidade;
            int size;

            switch (option){
                case 1:
                    for(Artigos aux: serverObject.getArtigos()){
                        System.out.println(aux);
                    }
                    break;

                case 2:
                    System.out.println("Insira o nome do artigo a Vender:");
                    search = serverObject.ProcurarArtigo(ler.umaString());
                    size = serverObject.getVendas(1).size();
                    if(!search.equals(new Artigos())){
                        System.out.println("Insira a quantidade de venda:");
                        quantidade = ler.umInt();
                        if(quantidade> search.getStock()){
                            System.out.println("Nao tem stock suficiente!!");
                            break;
                        }else{
                            if(serverObject.addVenda(search,quantidade) == size){
                                System.out.println("Venda não adicionada");
                            }else{
                                System.out.println("Venda realizada");
                            }
                            serverObject.escreverArtigos();
                            serverObject.escreverVendas();
                        }
                    }else{
                        System.out.println("Artigo não encontrado");
                    }
                    break;

                case 3:
                    System.out.println("Número de acessos");
                    System.out.println(serverObject.getCount());
                    break;

                case 4:
                    System.out.println("Insira o nome do artigo a procurar");
                    search = serverObject.ProcurarArtigo(ler.umaString());
                    if(search.equals(new Artigos()))
                        System.out.println("Artigo não encontrado");
                    else
                        System.out.println("Artigo encontrado");
                    break;

                case 5:
                    System.out.println("Vendas:");
                    System.out.println("1- Por Nome\n2- Por Data\n3- Por Quantidade\n");
                    option2 = ler.umInt();
                    System.out.println(serverObject.getVendas(option2));

                case 0:
                    serverObject.escreverArtigos();
                    break;
            }
        }
    }
}
