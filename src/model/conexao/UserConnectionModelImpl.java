package model.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import controller.usuarios.UsuarioController;

public class UserConnectionModelImpl extends ConexaoModel implements UserConnectionModel {

    public UserConnectionModelImpl() {}

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
}