package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Autor;

public class AutorDao {

    private static ArrayList<Autor> autores = new ArrayList<Autor>();

    public void salvar(Autor autor) throws Exception {
        autores.add(autor);
    }
    
    public Autor getPorCodigo(Integer codigo) {
        for (Autor autor : autores) {
            if (autor.getCodigo().equals(codigo)) {
                return autor; 
            }
        }
        return null; 
    }

    public List<Autor> recuperarTodos() throws Exception {
        return autores;
    }

    public void remover(Autor autor) {
        autores.remove(autor);
    }
}
