package pt.ubi;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VendedorInterface extends java.rmi.Remote{

    public java.util.Date getDate() throws java.rmi.RemoteException;

    public int getCount() throws java.rmi.RemoteException;

    //Files do Vendedor
    public int escreverArtigos() throws java.rmi.RemoteException;

    public int escreverVendas() throws java.rmi.RemoteException;

    //Funçoes do vendedor
    public Artigos ProcurarArtigo(String nome) throws java.rmi.RemoteException;

    public Trans ProcurarVendas(String nome) throws java.rmi.RemoteException;

    public int addVenda(Artigos art, int quantidade) throws java.rmi.RemoteException;

    public ArrayList<Artigos> getArtigos() throws java.rmi.RemoteException;

    public ArrayList<Trans> getVendas(int flag) throws  java.rmi.RemoteException;
}
