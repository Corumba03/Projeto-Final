package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoImpl implements Conexao{

    protected static Connection connection = null;

    public ConexaoImpl() {
        String url = "jdbc:sqlite:db/projetoMC322.db";

        try {
            // Carregar o Driver JDBC
            Class.forName("org.sqlite.JDBC");
            
            // Estabelecer a Conexão
            this.connection = DriverManager.getConnection(url);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Connection getConexao(){ return connection; }

    public void encerrarConexao(){
        try{
            connection.close();
        } catch (SQLException e){
            System.out.println("--> Conexao.java");
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }
    }
}

