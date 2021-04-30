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

        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }

    try {
        FornecedorImplements forImplements = new FornecedorImplements("Fornecedor");
        System.out.println("Servidor está OK");
    }
    catch (Exception e) {
        System.out.println("Erro no servidor " + e);
    }

}

    public static void main(String args[]) {
        new Server();
    }
}
