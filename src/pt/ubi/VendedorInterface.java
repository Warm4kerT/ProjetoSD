package pt.ubi;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VendedorInterface extends java.rmi.Remote{

    public java.util.Date getDate() throws java.rmi.RemoteException;
    public int getCount() throws java.rmi.RemoteException;

    public int removerArtigo(String nome) throws java.rmi.RemoteException;

    public int ProcurarArtigo(String nome) throws java.rmi.RemoteException;

    public int escreverArtigos() throws java.rmi.RemoteException;

    public ArrayList<Artigos> getArtigos() throws java.rmi.RemoteException;

    public int addArtigo(Artigos art) throws RemoteException;

}