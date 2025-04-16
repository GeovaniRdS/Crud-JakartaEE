package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Livro;

public class LivroDao {

    private static ArrayList<Livro> livros = new ArrayList<Livro>();

    public void salvar(Livro livro) throws Exception {
        livros.add(livro);
    }
    
    public Livro getPorCodigo(Integer codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro; 
            }
        }
        return null; 
    }

    public List<Livro> recuperarTodos() throws Exception {
        return livros;
    }

    public void remover(Livro livro) {
        livros.remove(livro);
    }
}
