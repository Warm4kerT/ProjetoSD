package pt.ubi;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Trans implements Serializable, Comparable<Trans>{ //Classe de transações, inclui os metodos standard(setters, getters...) e ainda mais os métodos de sort(nome, data, quantidade)
    public Artigos art;
    public Date data;
    public int quantidade;

    public Trans() {
        this.art = null;
        data = null;
        quantidade = 0;
    }

    public Trans(Artigos art, int quantidade) {
        this.art = art;
        this.data = new Date();
        this.quantidade = quantidade;
    }

    public Artigos getArt() {
        return art;
    }

    public void setArt(Artigos art) {
        this.art = art;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trans trans = (Trans) o;
        return quantidade == trans.quantidade && Objects.equals(art, trans.art) && Objects.equals(data, trans.data);
    }

    @Override
    public String toString() {
        return "Trans{" +
                "Artigo=" + art.getNome() +
                ", data=" + data +
                ", quantidade=" + quantidade +
                "}\n";
    }

    //Estes métodos permitem reorganizar o objeto consoante a preferencia do utilizador
    @Override
    public int compareTo(Trans o) {   //por ordem alfabética
        return this.getArt().getNome().compareTo(o.getArt().getNome());
    }

     public int compareToData(Trans o) {//por ordem da data, do mais
        return this.getData().compareTo(o.getData());
     }
     public int compareToQuant(Trans o) {
         if (o.getQuantidade() > this.getQuantidade()) {
             return 1;
         } else if (o.getQuantidade() < this.getQuantidade()) {
             return -1;
         }

         return 0;
     }

}
