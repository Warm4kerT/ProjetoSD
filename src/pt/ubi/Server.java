/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Server{
public Server() {

        System.setSecurityManager(new SecurityManager());
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");

            Fornecedor f = new FornecedorImpl("Fornecedor");
            System.out.println("cheguei aqui 1");
            Vendedor v = new VendedorImpl("Vendedor");
            System.out.println("------------");
            Negociar n = new NegociarImpl(f);
            Naming.rebind("negociar", n);
            System.out.println("Servidor esta okay");
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    public static void main(String args[]) {
        new Server();
    }
}
