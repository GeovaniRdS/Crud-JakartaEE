package jakarta.beans;

public class Livro {

    private Integer codigo;
    private String titulo;
    private Autor autor;  

    public Livro(Integer codigo, String titulo, Autor autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
