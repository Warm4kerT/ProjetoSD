package pt.ubi;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FornecedorInterface extends java.rmi.Remote {

    public java.util.Date getDate() throws java.rmi.RemoteException;

    // Ler e ecrever files
    public int lerArtigos() throws java.rmi.RemoteException;

    public int escreverArtigos() throws java.rmi.RemoteException;

    public int escreverCompras() throws java.rmi.RemoteException;

    //Funçoes para o fornecedor sobre Artigos
    public int getCount() throws java.rmi.RemoteException;

    public int addArtigo(Artigos art) throws RemoteException;

    public int addCompra(Artigos art, int quantidade) throws RemoteException;

    public int removerArtigo(String nome) throws java.rmi.RemoteException;

    public Artigos ProcurarArtigo(String nome) throws java.rmi.RemoteException;

    public ArrayList<Artigos> getArtigos() throws java.rmi.RemoteException;

    public ArrayList<Trans> getCompras(int flag) throws java.rmi.RemoteException;

}
