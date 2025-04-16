package jakarta.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.beans.Personagem;

public class PersonagemDao {

    private static ArrayList<Personagem> personagens = new ArrayList<Personagem>();

    public void salvar(Personagem personagem) throws Exception {
        personagens.add(personagem);
    }

    public List<Personagem> recuperarTodos() throws Exception {
        return personagens;
    }

    public void remover(Personagem personagem) {
        personagens.remove(personagem);
    }
}
