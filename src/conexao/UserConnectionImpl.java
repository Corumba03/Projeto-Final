package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usuarios.Usuario;

public class UserConnectionImpl extends ConexaoImpl implements UserConnection {

    Connection conexao;

    private Map<String, String> dados = new HashMap<>();
    private Map<String, String> destinos = new HashMap<>();

    public UserConnectionImpl(Connection conexao) {
        try {
            this.conexao = conexao;
            // Carregando o Driver JDBC
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Map<String, String> consultarDados(int id) {
        // Executar Consultas SQL
        String qry = "SELECT * FROM DM_USUARIOS WHERE ID_USUARIO = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(qry);

            // Processando Resultados
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("NOME"));
                dados.put("ID_USUARIO", resultSet.getString("ID_USUARIO"));
                dados.put("NOME", resultSet.getString("NOME"));
                dados.put("CPF", resultSet.getString("CPF"));
                dados.put("ID_PACOTE", resultSet.getString("ID_PACOTE"));
                dados.put("LAST_UPDATE", resultSet.getString("LAST_UPDATE"));

                System.out.println(dados);
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }

        return this.dados;

    }

    public Map<String, String> consultarDestinos(int id) {

        // Executar Consultas SQL
        String qry = "SELECT * FROM FT_VIAGENS WHERE ID_USUARIO = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(qry);

            // Processando Resultados
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dados.put("ID_USUARIO", resultSet.getString("ID_USUARIO"));
                dados.put("ID_PACOTE", resultSet.getString("ID_PACOTE"));
                dados.put("NOME", resultSet.getString("NOME"));
                dados.put("CPF", resultSet.getString("CPF"));
                dados.put("PACOTE", resultSet.getString("PACOTE"));
                dados.put("CATEGORIA", resultSet.getString("CATEGORIA"));
                dados.put("DATA_RESERVA", resultSet.getString("DATA_RESERVA"));
                dados.put("DATA_CARGA", resultSet.getString("DATA_CARGA"));

                System.out.println(dados);
            }

            // Fechando recursos
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("UserConnectionError");
            System.out.println("--> " + e.getErrorCode() + ": " + e.getMessage());
        }

        return this.destinos;
    }
    
    public void criarUsuario(Usuario usuario) {
    }

    public void removerUsuario(int id) {
    }

    public void editarUsuario(int id, String campo, String dado) {
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>();
    }

}