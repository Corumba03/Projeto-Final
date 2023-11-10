package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    
    public Database() {
        // URL de conexão com o banco de dados SQLite
        String url = "jdbc:sqlite:db/projetoMC322.db";

        try {
            // Carregar o Driver JDBC
            Class.forName("org.sqlite.JDBC");

            // Estabelecer a Conexão
            Connection connection = DriverManager.getConnection(url);

            // Executar Consultas SQL
            String sqlQuery = "SELECT * FROM DM_PACOTES";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            // Passo 4: Processar Resultados
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Processar os dados do resultado
                int id = resultSet.getInt("ID_PACOTE");
                String nomePacote = resultSet.getString("PACOTE");

                // Faça algo com os dados...
                System.out.println(id + ": " + nomePacote);
            }

            // Fechar recursos
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

