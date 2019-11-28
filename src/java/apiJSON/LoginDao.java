package apiJSON;


import java.sql.*;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginDao {

    public static boolean validate(String nomeUsuario, String senhaUsuario) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///desenvolvimentoweb", "root", "");

            PreparedStatement ps = con.prepareStatement(
                    "select * from usuario where nomeUsuario=? and senhaUsuario=?");
            ps.setString(1, nomeUsuario);
            ps.setString(2, senhaUsuario);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
        
    }
    public static JSONArray getUsuario(){
        ArrayList<String> result = new ArrayList<String>();
        JSONObject obj = new JSONObject();
        JSONArray lista = new JSONArray();
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql:///desenvolvimentoweb", "root", "");
        ArrayList<String>usuarios = new ArrayList<String>();
        PreparedStatement ps = con.prepareStatement(
                    "select * from usuario");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                obj = new JSONObject();
                obj.put("ID", rs.getString("idUsuario"));
                obj.put("Nome", rs.getString("nomeUsuario"));
                obj.put("Senha", rs.getString("senhaUsuario"));
                lista.put(obj);
            }
            result = usuarios;
            } catch (Exception e) {
            System.out.println(e);
        }
        
    return  lista;
}
}