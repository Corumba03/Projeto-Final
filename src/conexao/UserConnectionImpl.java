package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usuarios.Usuario;

public class UserConnectionImpl extends ConexaoImpl implements UserConnection {

    public static Connection conexao;

    private Map<String, String> dados = new HashMap<>();
    private Map<String, String> destinos = new HashMap<>();

    public UserConnectionImpl(Connection conexao) {
        try {
            // Carregando o Driver JDBC
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void setConexao(Connection con){ conexao = con; }

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

            resultSet.close();
            preparedStatement.close();
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
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("UserConnectionError");
            System.out.println("--> " + e.getErrorCode() + ": " + e.getMessage());
        }

        return this.destinos;
    }
    
    public static void criarUsuario(Usuario usuario) {
        String qry = String.format("INSERT INTO DM_USUARIOS (CPF, NOME, LAST_UPDATE, ID_PACOTE) VALUES ('%s', '%s', CURRENT_TIMESTAMP, %s)", usuario.getCpf(), usuario.getNome(), usuario.getTipoPacote());
        // System.out.println(qry);
        try{
            PreparedStatement stt = connection.prepareStatement(qry);
            int numOperacao = stt.executeUpdate();
            System.out.println(numOperacao + ". Inserção bem sucedida.");
        } catch (SQLException e){
            System.out.println("--> UserConnection creation:");
            System.out.println(String.format("%d: %s", e.getErrorCode(), e.getMessage()));
        }
    }

    public static void removerUsuario(String cpf) {
        // Query SQL para deletar a linha com base no CPF
        String query = String.format("DELETE FROM DM_USUARIOS WHERE CPF = %s", cpf);

        try {

            // Preparar a declaração SQL
            PreparedStatement stt = connection.prepareStatement(query);

            // Executar a query
            int numOperacao = stt.executeUpdate();
            System.out.println(numOperacao + ". Usuario deletado com sucesso.");

            // Fechar recursos
            stt.close();

        } catch (SQLException e) {
            System.out.println("--> UserConnection removal:");
            System.out.println(String.format("%d: %s", e.getErrorCode(), e.getMessage()));
        }
    }

    public static void editarUsuario(int id, String campo, String dado) {
    }

    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        // Executar Consultas SQL
        String qry = "SELECT * FROM DM_USUARIOS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(qry);

            // Processando Resultados
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(new Usuario(
                    resultSet.getString("CPF"),
                    resultSet.getString("NOME"),
                    // resultSet.getString("SENHA"),
                    new char[] {'s','e','n','h','a'},
                    // resultSet.getString("EMAIL"),
                    "EmailGenerico",
                    resultSet.getInt("ID_PACOTE")
                    ));
            }

            // Fechando recursos
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("UserConnectionError");
            System.out.println("--> " + e.getErrorCode() + ": " + e.getMessage());
        }
        return usuarios;
    }
}