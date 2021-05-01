package pt.ubi;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Trans implements Serializable {
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
                '}';
    }
}
