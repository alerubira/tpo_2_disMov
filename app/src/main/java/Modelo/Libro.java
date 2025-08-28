package Modelo;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int paginas;
    private String resnia;

    public Libro() {
    }

    public Libro(String titulo, String autor, int paginas, String resña) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.resnia = resnia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getResnia() {
        return resnia;
    }

    public void setResnia(String resnia) {
        this.resnia = resnia;
    }
}
