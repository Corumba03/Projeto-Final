package controller;

import model.pacotesViagem.AtividadeModel;
import model.pacotesViagem.DestinoModel;
import model.pacotesViagem.PlanoPacoteModel;

public class PacoteViagemController {
    String categoria; // A categoria (Aventura, Relaxamento, Cultura, etc) do pacote
    PlanoPacoteModel plano; // Premium, Basico, Lite
    private DestinoModel destino; // Destino da viagem
    private AtividadeModel atividade; // Lista de atividades inclusas no pacote
    private int avaliacao; // avaliacao media de turistas sobre a viagem (de 0 a 10)
    private double precoBase;
    private double descontoBase; // Desconto percentual base (é convertido para decimal)

    public PacoteViagemController(String categoria, PlanoPacoteModel plano, DestinoModel destino,
            AtividadeModel atividade, int avaliacao, double precoBase, double descontoBase) {
        this.categoria = categoria;
        this.plano = plano;
        this.destino = destino;
        this.atividade = atividade;
        this.avaliacao = avaliacao;
        this.precoBase = precoBase;
        this.descontoBase = descontoBase;
    }

    public String getCategoria() {
        return categoria;
    }

    public PlanoPacoteModel getPlano() {
        return plano;
    }

    public AtividadeModel getAtividade() {
        return atividade;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public double getDescontoBase() {
        return descontoBase;
    }   

    public DestinoModel getDestino() { return destino; }
}
