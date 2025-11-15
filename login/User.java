package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    // Conexão com o banco
    public Connection conectarBD(){

        Connection conn = null;

        try {
            // Driver correto
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL de conexão do banco
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Para conectar
            conn = DriverManager.getConnection(url);

        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }

        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha){

        // SQL no c´doigo
        String sql = "select nome from usuarios "
                   + "where login = '" + login + "' "
                   + "and senha = '" + senha + "';";

        Connection conn = conectarBD();

        // Se a conexão nãoi der certo, não continua
        if (conn == null) {
            System.out.println("Conexão voltou null...");
            return false;
        }

        try {

            // Cria o statement
            Statement st = conn.createStatement();

            // Executa a SQL
            ResultSet rs = st.executeQuery(sql);

            // Se encontrou o usuário
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }

            rs.close();  // fechando o ResultSet
            st.close();  // fechando o Statement
            conn.close(); // fechando a conexão

        } catch (Exception e) {
            System.out.println("Erro ao verificar usuario: " + e.getMessage());
        }

        // Retorna se achou ou não
        return result;
    }
}
