package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserCódigoErro {

    //(01)
    public Connection conectarBD(){

        Connection conn = null;
        try{ //(02)
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } //(03)
        catch (Exception e) { //(04)

        } //(05)
        
        return conn; 
    }//(06)

    public String nome="";
    public boolean result = false;

    //(07)
    public boolean verificarUsuario(String login, String senha){
        String sql = "";

        
        Connection conn = conectarBD();
        //(08)
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        
        try{ //(09)
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

        
            if(rs.next()){ //(10)

            
                result = true;
                nome = rs.getString("nome");
            }//(11)
        }//(12)
        
        
        catch (Exception e) { //(13)

        }//(14)

 
        return result;
    } //(15)
}//(16)
