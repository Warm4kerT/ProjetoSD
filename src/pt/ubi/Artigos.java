package pt.ubi;

import java.io.Serializable;
import java.util.Objects;

public class Artigos implements Serializable{ //Classe Artigos com metodos basicos para trabalhar com o objeto
    private String nome, categoria, desporto, marca;
    private float preço;
    private int stock;

    public Artigos() {
        this.nome = null;
        this.categoria = null;
        this.desporto = null;
        this.marca = null;
        this.preço = 0;
        this.stock = 0;
    }

    public Artigos(String nome, String categoria, String desporto, String marca, float preço, int stock) {
        this.nome = nome;
        this.categoria = categoria;
        this.desporto = desporto;
        this.marca = marca;
        this.preço = preço;
        this.stock = stock;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDesporto() {
        return desporto;
    }

    public void setDesporto(String desporto) {
        this.desporto = desporto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Artigos{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", desporto='" + desporto + '\'' +
                ", marca='" + marca + '\'' +
                ", preço=" + preço +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artigos artigos = (Artigos) o;
        return Float.compare(artigos.preço, preço) == 0 && stock == artigos.stock && nome.equals(artigos.nome) && categoria.equals(artigos.categoria) && desporto.equals(artigos.desporto) && marca.equals(artigos.marca);
    }

}
