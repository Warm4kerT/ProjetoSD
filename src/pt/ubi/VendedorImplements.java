package pt.ubi;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VendedorImplements extends UnicastRemoteObject implements pt.ubi.VendedorInterface, Serializable {

    public int count = 0;
    public ListaArtigos listagem = new ListaArtigos();

    public VendedorImplements(String name, ListaArtigos list) throws RemoteException {
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
    public int escreverArtigos() throws RemoteException {
        count++;
        return listagem.escreverArtigos();
    }

    @Override
    public int escreverVendas() throws RemoteException {
        count++;
        return listagem.escreverVendas();
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
    public Artigos ProcurarArtigo(String nome) throws RemoteException {
        count++;
        return listagem.ProcurarArtigo(nome);
    }

    @Override
    public Trans ProcurarVendas(String nome) throws RemoteException {
        count++;
        return listagem.ProcurarVendas(nome);
    }

    @Override
    public ArrayList<Trans> getVendas(int flag) throws  java.rmi.RemoteException{
        count++;
        return listagem.getVendas(flag);
    }

    @Override
    public int addVenda(Artigos art, int quantidade) throws java.rmi.RemoteException{
        count++;
        return listagem.addVenda(art,quantidade);
    }
}
