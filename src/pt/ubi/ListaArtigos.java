package pt.ubi;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ListaArtigos {
    public ArrayList<Artigos> listagem = new ArrayList<>();
    public ArrayList<Trans> vendas = new ArrayList<>();
    public ArrayList<Trans> compras = new ArrayList<>();

    public int lerArtigos(){ //Ler os artigos do ficheiro

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("./Artigos.dat"));
            listagem = (ArrayList <Artigos>) is.readObject();
            ObjectInputStream is2 = new ObjectInputStream(new FileInputStream("./Vendidos.dat"));
            vendas = (ArrayList<Trans>) is2.readObject();
            ObjectInputStream is3 = new ObjectInputStream(new FileInputStream("./Compras.dat"));
            compras = (ArrayList<Trans>) is3.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return 0;
        }

        return 1;
    }


    public int escreverArtigos(){ //Escrever os artigos no ficherio
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("./Artigos.dat"));
            os.writeObject(listagem);
            os.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return 0;
        }

        return 1;
    }

    public int escreverVendas(){ //Escrever as Vendas no ficherio
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("./Vendidos.dat"));
            os.writeObject(vendas);
            os.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return 0;
        }

        return 1;
    }

    public int escreverCompras(){ //Escrever as Compras no ficherio
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("./Compras.dat"));
            os.writeObject(compras);
            os.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return 0;
        }

        return 1;
    }

    public Artigos ProcurarArtigo(String nome){ // Procurar artigos disponiveis
        System.out.println("Entrei no artigo");
        for (Artigos aux : listagem) {
            if (aux.getNome().compareTo(nome) == 0) {
                System.out.println(aux.toString());
                return aux;
            }
        }

        System.out.println("Artigo não encontrado");
        return new Artigos();
    }

    public Trans ProcurarVendas(String nome){ // Procurar artigos vendidos
        System.out.println("Entrei no artigo");
        for (Trans aux : vendas) {
            if (aux.getArt().getNome().compareTo(nome) == 0) {
                System.out.println(aux.toString());
                return aux;
            }
        }

        System.out.println("Artigo não encontrado");
        return new Trans();
    }

    public Trans ProcurarCompras(String nome){ // Procurar artigos comprados
        System.out.println("Entrei no artigo");
        for (Trans aux : compras) {
            if (aux.getArt().getNome().compareTo(nome) == 0) {
                System.out.println(aux.toString());
                return aux;
            }
        }

        System.out.println("Artigo não encontrado");
        return new Trans();
    }

    public int removerArtigo(String nome){
        for (Artigos aux : listagem) {
            if (aux.getNome().compareTo(nome) == 0) {
                listagem.remove(aux);
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<Artigos> getLista(){ return listagem;}

    public ArrayList<Trans> getCompras(){ return compras;}

    public ArrayList<Trans> getVendas(){ return vendas;}

    public int addArtigo(Artigos art){ // Adicionar Artigo

        for(Artigos aux:listagem){
            if (aux.equals(art)){
                return listagem.size();
            }
        }

        listagem.add(art);
        return listagem.size();
    }

    public int addVenda(Artigos art, int quantidade){ //Adicionar vendas
        Trans nova;
        for (Artigos aux : listagem) {
            if (aux.equals(art)) {
                aux.setStock(aux.getStock()-quantidade);
                nova = new Trans(aux, quantidade);
                vendas.add(nova);
                return vendas.size();
            }
        }

        return vendas.size();
    }

    public int addCompra(Artigos art, int quantidade){ //Adicionar compras

        Trans nova;
        for (Artigos aux : listagem) {
            if (aux.equals(art)) {
                aux.setStock(aux.getStock()+quantidade);
                nova = new Trans(aux, quantidade);
                compras.add(nova);
                return compras.size();
            }
        }

        return compras.size();
    }

}
