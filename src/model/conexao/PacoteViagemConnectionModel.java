package model.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.PacoteViagemController;
import model.pacotesViagem.CategoriaDestinoModel;
import model.pacotesViagem.DestinoModel;
import model.pacotesViagem.PlanoPacoteModel;


public class PacoteViagemConnectionModel extends ConexaoModel{
    public PacoteViagemConnectionModel(){}

    public static List<PacoteViagemController> buscarPacotePorDestino(String destino){

        List<PacoteViagemController> pacotes = new ArrayList<>();
        
        // Recuperando pacoteViagem
        try {
            DestinoModel destinoModel = DestinosConnectionModel.buscarDestino(destino);
            if (destinoModel == null){
                System.out.println("O destino informado não existe.");
                return null;
            }
            String qry = String.format("SELECT * FROM DM_PACOTE_VIAGEM WHERE nome_destino = '%s'", destinoModel.getNome());
            PreparedStatement stt = connection.prepareStatement(qry);

            // Processando Resultados
            ResultSet resultado = stt.executeQuery();
            while(resultado.next()){
                PacoteViagemController pct = new PacoteViagemController(
                        resultado.getString("categoria"),
                        PlanoPacoteModel.valueOf(resultado.getString("plano")),
                        destinoModel,
                        destinoModel.getAtividade(),
                        resultado.getInt("avaliacao"),
                        resultado.getDouble("precoBase"),
                        resultado.getDouble("descontoBase")
                    );
                pacotes.add(pct);
            }
            resultado.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }

        return pacotes;
    }

    public static List<PacoteViagemController> buscarPacotePorCategoria(CategoriaDestinoModel categoria){
        List<PacoteViagemController> pacotes = new ArrayList<>();

        // Recuperando pacoteViagem
        try {
            String qry = String.format("SELECT * FROM DM_PACOTE_VIAGEM WHERE categoria = '%s'", categoria);
            PreparedStatement stt = connection.prepareStatement(qry);
            ResultSet resultado = stt.executeQuery();

            // Processando Resultados
            while(resultado.next()){
                DestinoModel destinoModel = DestinosConnectionModel.buscarDestino(resultado.getString("nome_destino"));
                PacoteViagemController pct = new PacoteViagemController(
                        resultado.getString("categoria"),
                        PlanoPacoteModel.valueOf(resultado.getString("plano")),
                        destinoModel,
                        destinoModel.getAtividade(),
                        resultado.getInt("avaliacao"),
                        resultado.getDouble("precoBase"),
                        resultado.getDouble("descontoBase")
                    );
                pacotes.add(pct);
            }
            resultado.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }

        return pacotes;
    }

    public static List<PacoteViagemController> buscarPacotePorPrecoMax(double preco){
        List<PacoteViagemController> pacotes = new ArrayList<>();

        // Recuperando pacoteViagem
        try {
            // Recuperando todos valores com desconto 
            String qry = "SELECT * FROM DM_PACOTE_VIAGEM WHERE (precoBase - (descontoBase/100)*precoBase) <= " + preco;
            PreparedStatement stt = connection.prepareStatement(qry);

            // Processando Resultados
            ResultSet resultado = stt.executeQuery();
            while(resultado.next()){
                DestinoModel destinoModel = DestinosConnectionModel.buscarDestino(resultado.getString("nome_destino"));
                PacoteViagemController pct = new PacoteViagemController(
                        resultado.getString("categoria"),
                        PlanoPacoteModel.valueOf(resultado.getString("plano")),
                        destinoModel,
                        destinoModel.getAtividade(),
                        resultado.getInt("avaliacao"),
                        resultado.getDouble("precoBase"),
                        resultado.getDouble("descontoBase")
                    );
                pacotes.add(pct);
            }
            resultado.close();
            stt.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + ": " + e.getMessage());
        }

        return pacotes;
    }

    // TODO Funcoes pra adm
    public static void adicionarPacote(int id){}
    public static void editarPacote(int id){}
    public static void removerPacote(int id){}
}