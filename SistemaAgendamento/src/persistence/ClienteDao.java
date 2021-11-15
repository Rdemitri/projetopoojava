package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ClienteDao {
   private Connection con;
   private PreparedStatement st;

    public boolean conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/acesso", "root", "concha37");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
           return false;
        }
    }
    
    public boolean salvar(Cliente cliente){
        try {
            st = con.prepareStatement("INSERT INTO cliente VALUES(?,?,?)");
            
            st.setString(1, cliente.getId());
            st.setString(2, cliente.getNome());
            st.setString(6, cliente.getTelefone());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
}
