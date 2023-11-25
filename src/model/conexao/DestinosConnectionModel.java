package model.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.pacotesViagem.AtividadeModel;
import model.pacotesViagem.DestinoModel;

public class DestinosConnectionModel extends ConexaoModel {

    public DestinosConnectionModel() {}

    public static DestinoModel buscarDestino(String destino){
        DestinoModel destinoModel = null;
        String qry = String.format("SELECT * FROM DM_DESTINOS WHERE nome = '%s'", destino);
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            try (ResultSet resultado = stt.executeQuery()) {
                int id_atividade = resultado.getInt("ID_ATIVIDADE");
                AtividadeModel atv = AtividadeConnectionModel.buscarAtividade(id_atividade);
                while (resultado.next()) {
                    destinoModel = new DestinoModel(
                        resultado.getString("nome"),
                        resultado.getString("info"),
                        atv
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("---> DestinosConnectionModel");
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }
        return destinoModel;
    }
}
