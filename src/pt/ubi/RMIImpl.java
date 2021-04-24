/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class RMIImpl extends UnicastRemoteObject implements pt.ubi.RMIInterface {
 public RMIImpl(String name) throws RemoteException {
    super();
    try {
        Naming.rebind(name, this);
    }catch (MalformedURLException | RemoteException e) {
        if (e instanceof RemoteException)
            throw (RemoteException)e;
        else
            throw new RemoteException(e.getMessage());
    }
   }
 
 @Override
    public java.util.Date getDate() {
        System.out.println(" Método remoto -- RMIImpl.getDate()");
        return new java.util.Date();
    }
}

