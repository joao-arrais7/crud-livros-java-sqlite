package crud;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private double preco;

    public Livro() {}

    public Livro(String titulo, String autor, int ano, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
    }

    // Getters e Setters
    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
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

    public int getAno() { 
        return ano; 
    }

    public void setAno(int ano) { 
        this.ano = ano; 
    }

    public double getPreco() { 
        return preco; 
    }

    public void setPreco(double preco) { 
        this.preco = preco; 
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " | " + autor + " | " + ano + " | R$ " + preco;
    }
}
