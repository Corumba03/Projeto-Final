package model.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.pacotesViagem.AtividadeModel;
import model.pacotesViagem.DificuldadeModel;

public class AtividadeConnectionModel extends ConexaoModel{
    
    public AtividadeConnectionModel(){}

    public static AtividadeModel buscarAtividade(int id){
        AtividadeModel atividade = null;
        String qry = "SELECT * FROM DM_ATIVIDADES WHERE id = " + id;
        try {
            PreparedStatement stt = connection.prepareStatement(qry);
            try (ResultSet resultado = stt.executeQuery()) {
                
                while (resultado.next()) {
                    atividade = new AtividadeModel(
                        resultado.getString("nome"),
                        resultado.getString("resumo"),
                        resultado.getString("descricao"),
                        resultado.getString("duracao"),
                        DificuldadeModel.valueOf(resultado.getString("dificuldade")),
                        resultado.getString("disponibilidade"),
                        resultado.getString("cuidados"),
                        resultado.getString("equipamentos")
                    );
                }
            }
        } catch (SQLException e) {
            // Lide com exceções aqui
            e.printStackTrace();
        }
        return atividade;
    }
}
