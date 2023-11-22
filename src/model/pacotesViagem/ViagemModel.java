package model.pacotesViagem;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ViagemModel {
    private DestinoModel destino; // Destino da viagem
    private String pontoSaida; // De onde o voo sai
    private double precoBase; // Preço por pessoa
    private Set<LocalDateTime> datasDisponiveis;

    public ViagemModel(DestinoModel destino, String pontoSaida, double precoBase) {
        this.destino = destino;
        this.pontoSaida = pontoSaida;
        this.precoBase = precoBase;
        this.datasDisponiveis = new HashSet<>();
    }

    public DestinoModel getDestino() {
        return destino;
    }

    public void setDestino(DestinoModel destino) {
        this.destino = destino;
    }

    public String getPontoSaida() {
        return pontoSaida;
    }

    public void setPontoSaida(String pontoSaida) {
        this.pontoSaida = pontoSaida;
    }

    public double getPreco() {
        return precoBase;
    }

    public void setPreco(double precoBase) {
        this.precoBase = precoBase;
    }

    public Set<LocalDateTime> getDatasDisponiveis() {
        return datasDisponiveis;
    }

    public void setDatasDisponiveis(Set<LocalDateTime> datasDisponiveis) {
        this.datasDisponiveis = datasDisponiveis;
    }
    // Outros métodos
   public void addData(LocalDateTime data){
        this.datasDisponiveis.add(data);
   }
}
