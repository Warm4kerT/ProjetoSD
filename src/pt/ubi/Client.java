/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Date;

public class Client{
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
            RMIInterface myServerObject =
            (RMIInterface) Naming.lookup("//"+serverName+"/RMIImpl");
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

    public static void menu(RMIInterface serverObject) throws RemoteException{
        int option = 20;

        while(option != 0){
            System.out.println("------Menu------\n" +
                    "1-Listar\n" +
                    "2-Inserir\n");

            option = ler.umInt();

            switch (option){
                case 1:
                    for(Artigos aux: serverObject.getArtigos()){
                        System.out.println(aux);
                    }
                break;

                case 2:
                    System.out.println("Name: ");
                    String name = ler.umaString();
                    System.out.println("Categoria: ");
                    String Categoria = ler.umaString();
                    System.out.println("Marca: ");
                    String Marca = ler.umaString();
                    System.out.println("Desporto: ");
                    String Desporto = ler.umaString();
                    System.out.println("Preço: ");
                    float preco = ler.umFloat();
                    System.out.println("Stock: ");
                    int stock = ler.umInt();
                    Artigos aux = new Artigos(name,Categoria,Desporto,Marca,preco,stock);
                    serverObject.addArtigo(aux);
                    System.out.println("Registado");

                    break;

                case 0:
                    serverObject.escreverArtigos();
                    break;
            }
        }
    }
}
