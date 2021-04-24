package pt.ubi;

import java.io.*;
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
