/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author turtl
 */
public interface RMIInterface extends java.rmi.Remote{
    public java.util.Date getDate() throws java.rmi.RemoteException;

    public int lerArtigos() throws java.rmi.RemoteException;

    public int getCount() throws java.rmi.RemoteException;

    public int removerArtigo(String nome) throws java.rmi.RemoteException;

    public int ProcurarArtigo(String nome) throws java.rmi.RemoteException;

    public int escreverArtigos() throws java.rmi.RemoteException;

    public ArrayList<Artigos> getArtigos() throws java.rmi.RemoteException;

    public int addArtigo(Artigos art) throws RemoteException;

}
