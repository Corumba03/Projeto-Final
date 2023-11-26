package model.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import controller.PacoteViagemController;
import controller.usuarios.UsuarioController;

public class UserConnectionModelImpl extends ConexaoModel implements UserConnectionModel {

    public UserConnectionModelImpl() {
    }

    public static void listarUsuarios() {
        String qry = "SELECT * FROM DM_USUARIOS";
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            ResultSet resultados = stt.executeQuery();

            while (resultados.next()) {
                System.out.println(resultados.getString("Nome"));
            }
        } catch (SQLException e) {
            System.out.println("---> UserConnection listarUsuarios");
            System.out.println(String.format("%s: %s", e.getErrorCode(), e.getMessage()));
        }
    }

    public Map<String, String> consultarDados(int id) {

        // Executar Consultas SQL
        Map<String, String> dados = new HashMap<>();
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

        return dados;

    }

    public static void criarUsuario(UsuarioController usuario) {
        String qry = String.format(
                "INSERT INTO DM_USUARIOS (CPF, NOME, EMAIL, SENHA, LAST_UPDATE) VALUES ('%s', '%s', '%s', '%s', CURRENT_TIMESTAMP)",
                usuario.getCpf(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            int numOperacao = stt.executeUpdate();
            System.out.println(numOperacao + ". Inserção bem sucedida.");
        } catch (SQLException e) {
            System.out.println("--> UserConnection creation:");
            System.out.println(String.format("%d: %s", e.getErrorCode(), e.getMessage()));
        }
    }

    public static UsuarioController verificaUsuario(String email, String senha) {
        UsuarioController user = null;
        String qry = String.format("SELECT * FROM DM_USUARIOS WHERE email = '%s' AND senha = '%s'", email, senha);
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            ResultSet resultado = stt.executeQuery();

            while (resultado.next()) {
                user = new UsuarioController(
                        resultado.getString("CPF"),
                        resultado.getString("NOME"),
                        resultado.getString("SENHA").toCharArray(),
                        resultado.getString("EMAIL"));
            }
        } catch (SQLException e) {
            System.out.println("--> UserConnection UserConnection verificaUsuario:");
            System.out.println(String.format("%d: %s", e.getErrorCode(), e.getMessage()));
        }

        return user;
    }

    public static int obterIdUsuario(String cpf) {
        int id = 0;
        String qry = String.format("SELECT ID_USUARIO FROM DM_USUARIOS WHERE CPF = '%s'", cpf);
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            ResultSet res = stt.executeQuery();
            id = res.getInt("ID_USUARIO");
        } catch (SQLException e) {
            System.out.println("---> PacoteViagemConnection obterIdpacote");
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }
        return id;
    }

    public static void adicionarPacote(UsuarioController usuario, PacoteViagemController pacote) {
        int id_usuario = UserConnectionModelImpl.obterIdUsuario(usuario.getCpf());
        int id_pacote = PacoteViagemConnectionModel.obterIdPacote(pacote);
        String qry = String.format("INSERT INTO FT_VIAGENS(ID_USUARIO, ID_PACOTE, DATA_RESERVA) VALUES('%s', '%s', CURRENT_TIMESTAMP)", id_usuario, id_pacote);
        try{
            PreparedStatement stt = connection.prepareStatement(qry);
            stt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("--> UserConnection Add Pacote:");
            System.out.println(String.format("%d: %s", e.getErrorCode(), e.getMessage()));
        }
    }

}