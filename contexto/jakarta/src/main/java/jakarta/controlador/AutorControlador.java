package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Autor;
import jakarta.dao.AutorDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AutorControlador implements Serializable {

    private Autor autor = null;
    private List<Autor> autores = null;

    public boolean isMostrarTable() {
        return autores != null && autores.size() > 0;
    }

    public String menu() {
        return "menuprincipal.xhtml";
    }

    public void excluir(Autor autor) {
        AutorDao autorDao = new AutorDao();
        autorDao.remover(autor);
    }

    public String prepararConsulta() {
        try {
            AutorDao autorDao = new AutorDao();
            autores = autorDao.recuperarTodos();
            return "consultarautor.xhtml";
        } catch (Exception e) {
            return null;
        }
    }

    public String prepararCadastro() {
        autor = new Autor(null, "");
        return "cadastrarautor.xhtml";
    }

    public String processarAcaoCadastrar() {
        try {
            AutorDao dao = new AutorDao();
            dao.salvar(autor);
            return "menuprincipal.xhtml";
        } catch (Exception e) {
            return null;
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
