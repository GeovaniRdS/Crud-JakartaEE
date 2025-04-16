package jakarta.beans;

public class Personagem {

    private Integer codigo;
    private String nome;
    private Livro livro; 

    public Personagem(Integer codigo, String nome, Livro livro) {
        this.codigo = codigo;
        this.nome = nome;
        this.livro = livro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
