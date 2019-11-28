package Controller;

import java.util.ArrayList;
import java.util.Date;
import Model.ContatosBEAN;
import Model.ContatosDAO;
public class Controle {

    public Controle() {
    }

    public void addContato(ContatosBEAN usuario) {
        ContatosDAO.getInstance().create(usuario);
    }

    public void updateContato(ContatosBEAN usuario) {
        ContatosDAO.getInstance().update(usuario);
    }

    public void deleteContato(ContatosBEAN usuario) {
        ContatosDAO.getInstance().delete(usuario);
    }

    public ContatosBEAN findContato(int idUsuario) {
        return ContatosDAO.getInstance().findContato(idUsuario);
    }
    
    public ArrayList<ContatosBEAN> findAllPessoa() {
        return ContatosDAO.getInstance().findAllPessoa();
    }

    public int findIdContato(ContatosBEAN usuario) {
        return ContatosDAO.getInstance().findIdContato(usuario);
    }

    public Boolean isExist(int idUsuario) {
        return ContatosDAO.getInstance().isExist(idUsuario);
    }

    public ArrayList<ContatosBEAN> listaContatos() {
        return ContatosDAO.getInstance().findAllPessoa();
    }
    
}
