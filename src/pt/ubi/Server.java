/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements pt.ubi.ServerInterface{
    public ListaArtigos listagem = new ListaArtigos();
    public String message;

    @Override
    public void reciveMessage(String s){
        message = s;
    }

    @Override
    public void resetMessage(){
        message = null;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

    public Server() throws RemoteException {
        super();

        listagem.lerArtigos();
        FornecedorImplements forImplements;
        VendedorImplements venImplements;

        try {
            forImplements = new FornecedorImplements("Fornecedor",listagem);
            venImplements = new VendedorImplements("Vendedor",listagem);
            System.out.println("Servidor está OK");
        }
        catch (Exception e) {
            System.out.println("Erro no servidor " + e);
        }

}
       
    public static void main(String args[]) throws RemoteException {

        System.setSecurityManager(new SecurityManager());
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        System.out.println("RMI registry ready.");

        try {
            Server ser = new Server();
            Naming.rebind("Server",ser);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
