package jakarta.controlador;

import java.io.Serializable;
import java.util.List;

import jakarta.beans.Personagem;
import jakarta.beans.Livro;
import jakarta.dao.PersonagemDao;
import jakarta.dao.LivroDao;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class PersonagemControlador implements Serializable {

    private Personagem personagem = null;
    private List<Personagem> personagens = null;
    private List<Livro> livros = null;
    private Integer codigoLivroSelecionado;

    public boolean isMostrarTable() {
        return personagens != null && personagens.size() > 0;
    }

    public String menu() {
        return "menuprincipal.xhtml";
    }

    public void excluir(Personagem personagem) {
        PersonagemDao personagemDao = new PersonagemDao();
        personagemDao.remover(personagem);
    }

    public String prepararConsulta() {
        try {
            PersonagemDao personagemDao = new PersonagemDao();
            personagens = personagemDao.recuperarTodos();
            return "consultarpersonagem.xhtml";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String prepararCadastro() {
        personagem = new Personagem(null, "", null);  
        LivroDao livroDao = new LivroDao();
        try {
            livros = livroDao.recuperarTodos(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cadastrarpersonagem.xhtml"; 
    }

    public String processarAcaoCadastrar() {
        try {
            PersonagemDao dao = new PersonagemDao();
            LivroDao livroDao = new LivroDao();
            Livro livro = livroDao.getPorCodigo(codigoLivroSelecionado);  
            personagem.setLivro(livro);  
            dao.salvar(personagem);
            return "menuprincipal.xhtml"; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Integer getCodigoLivroSelecionado() {
        return codigoLivroSelecionado;
    }

    public void setCodigoLivroSelecionado(Integer codigoLivroSelecionado) {
        this.codigoLivroSelecionado = codigoLivroSelecionado;
    }
}
