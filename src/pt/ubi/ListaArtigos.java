package pt.ubi;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ListaArtigos {
    public ArrayList<Artigos> listagem = new ArrayList<>();

    public int lerArtigos(){ //Ler os artigos do ficheiro

        listagem.add(new Artigos("teste","teste","teste","teste",12,25));

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("./Artigos.dat"));
            listagem = (ArrayList <Artigos>) is.readObject();
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

    public int ProcurarArtigo(String nome){
        System.out.println("Entrei no artigo");
        for (Artigos aux : listagem) {
            if (aux.getNome().compareTo(nome) == 0) {
                System.out.println(aux.toString());
                return 1;
            }
        }

        System.out.println("Artigo não encontrado");
        return 0;
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

    public ArrayList<Artigos> getLista(){
        return listagem;
    }

    public int addArtigo(Artigos art){

        for(Artigos aux:listagem){
            if (aux.equals(art)){
                return listagem.size();
            }
        }

        listagem.add(art);
        return listagem.size();
    }
}
