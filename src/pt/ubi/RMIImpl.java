/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIImpl extends UnicastRemoteObject implements pt.ubi.RMIInterface, Serializable {

    public int count = 0;
    public ListaArtigos listagem = new ListaArtigos();

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

    @Override
    public int lerArtigos() throws RemoteException{
        count++;
        return listagem.lerArtigos();
    }

    @Override
    public int escreverArtigos() throws RemoteException {
        count++;
        return listagem.escreverArtigos();
    }

    @Override
    public ArrayList<Artigos> getArtigos() throws RemoteException{
        count++;
        return listagem.getLista();
    }

    public int getCount() throws RemoteException{
        count++;
        return count;
    }

    @Override
    public int addArtigo(Artigos art) throws RemoteException{
        count++;
        return listagem.addArtigo(art);
    }
}

