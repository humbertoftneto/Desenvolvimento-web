package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatosDAO {

    private static ContatosDAO instance;

    private ContatosDAO() {
        MySQLDAO.getConnection();
    }

    public static ContatosDAO getInstance() {
        if (instance == null) {
            instance = new ContatosDAO();
        }
        return instance;
    }

    public long create(ContatosBEAN usuario) {
        String query = "INSERT INTO usuario (nomeUsuario, senhaUsuario) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, usuario.getNomeUsuario(), usuario.getSenhaUsuario());
    }

    public void update(ContatosBEAN usuario) {
        String query = "UPDATE usuario SET nomeUsuario=?, senhaUsuario=? WHERE idUsuario = ?";
        MySQLDAO.executeQuery(query, usuario.getNomeUsuario(), usuario.getSenhaUsuario(), usuario.getIdUsuario());
    }

    public void delete(ContatosBEAN usuario) {
        MySQLDAO.executeQuery("DELETE FROM usuario WHERE idUsuario = ?", usuario.getIdUsuario());
    }

    public ArrayList<ContatosBEAN> findAllPessoa() {
        return listaContatos("SELECT * FROM usuario ORDER BY nomeUsuario");
    }

    public ArrayList<ContatosBEAN> listaContatos(String query) {
        ArrayList<ContatosBEAN> lista = new ArrayList<ContatosBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new ContatosBEAN(rs.getInt("idUsuario"), rs.getString("nomeUsuario"), rs.getString("senhaUsuario")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public ContatosBEAN findContato(int idUsuario) {
        ContatosBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM usuario WHERE idUsuario=?", idUsuario);
        try {
            if (rs.next()) {
                result = new ContatosBEAN(rs.getInt("idUsuario"), rs.getString("nomeUsuario"), rs.getString("senhaUsuario"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int findIdContato(ContatosBEAN usuario) {
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM usuario WHERE nomeUsuario= ? and senhaUsuario= ?", usuario.getNomeUsuario(), usuario.getSenhaUsuario());
        try {
            if (rs.next()) {
                result = rs.getInt("idUsuario");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean isExist(int idUsuario) {
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM usuario WHERE idUsuario= ?", idUsuario);
        try {
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
