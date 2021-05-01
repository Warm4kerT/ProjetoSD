package pt.ubi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FornecedorImplements extends UnicastRemoteObject implements pt.ubi.FornecedorInterface, Serializable {

    public int count = 0;
    public ListaArtigos listagem = new ListaArtigos();

    public FornecedorImplements(String name, ListaArtigos list) throws RemoteException {
        super();
        this.listagem = list;
        try {
            Naming.rebind(name, this);
        } catch (MalformedURLException | RemoteException e) {
            if (e instanceof RemoteException)
                throw (RemoteException) e;
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
    public int lerArtigos() throws RemoteException {
        count++;
        return listagem.lerArtigos();
    }

    @Override
    public int escreverArtigos() throws RemoteException {
        count++;
        return listagem.escreverArtigos();
    }

    @Override
    public ArrayList<Artigos> getArtigos() throws RemoteException {
        count++;
        return listagem.getLista();
    }

    public int getCount() throws RemoteException {
        count++;
        return count;
    }

    @Override
    public int removerArtigo(String nome) throws RemoteException {
        count++;
        return listagem.removerArtigo(nome);
    }

    @Override
    public Artigos ProcurarArtigo(String nome) throws RemoteException {
        count++;
        return listagem.ProcurarArtigo(nome);
    }

    @Override
    public int addArtigo(Artigos art) throws RemoteException{
        count++;
        return listagem.addArtigo(art);
    }

    @Override
    public int escreverCompras() throws RemoteException{
        count++;
        return listagem.escreverCompras();
    }

    @Override
    public int addCompra(Artigos art, int quantidade) throws RemoteException{
        count++;
        return listagem.addCompra(art,quantidade);
    }

    @Override
    public ArrayList<Trans> getCompras(int flag) throws java.rmi.RemoteException{
        count++;
        return listagem.getCompras(flag);
    }

}
