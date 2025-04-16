package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Livro;
import jakarta.beans.Autor;
import jakarta.dao.LivroDao;
import jakarta.dao.AutorDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class LivroControlador implements Serializable {

    private Livro livro = null;
    private List<Livro> livros = null;
    private List<Autor> autores = null;
    private Integer codigoAutorSelecionado;

    public boolean isMostrarTable() {
        return livros != null && livros.size() > 0;
    }

    public String menu() {
        return "menuprincipal.xhtml";
    }

    public void excluir(Livro livro) {
        LivroDao livroDao = new LivroDao();
        livroDao.remover(livro);
    }

    public String prepararConsulta() {
        try {
            LivroDao livroDao = new LivroDao();
            livros = livroDao.recuperarTodos();
            return "consultarlivro.xhtml";
        } catch (Exception e) {
            return null;
        }
    }

    public String prepararCadastro() {
        livro = new Livro(null, "", null);
        AutorDao autorDao = new AutorDao();
        try {
            autores = autorDao.recuperarTodos(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cadastrarlivro.xhtml";
    }

    public String processarAcaoCadastrar() {
        try {
            LivroDao dao = new LivroDao();
            AutorDao autorDao = new AutorDao();
            Autor autor = autorDao.getPorCodigo(codigoAutorSelecionado);  
            livro.setAutor(autor);  
            dao.salvar(livro); 
            return "menuprincipal.xhtml";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Integer getCodigoAutorSelecionado() {
        return codigoAutorSelecionado;
    }

    public void setCodigoAutorSelecionado(Integer codigoAutorSelecionado) {
        this.codigoAutorSelecionado = codigoAutorSelecionado;
    }
}
