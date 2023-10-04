package pacotes_viagem;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Viagem {
    private Destino destino; // Destino da viagem
    private String pontoSaida; // De onde o voo sai
    private double precoBase; // Preço por pessoa
    private Set<LocalDate> datasDisponiveis;

    public Viagem(Destino destino, String pontoSaida, double precoBase) {
        this.destino = destino;
        this.pontoSaida = pontoSaida;
        this.precoBase = precoBase;
        this.datasDisponiveis = new HashSet<>();
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
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

    public Set<LocalDate> getDatasDisponiveis() {
        return datasDisponiveis;
    }

    public void setDatasDisponiveis(Set<LocalDate> datasDisponiveis) {
        this.datasDisponiveis = datasDisponiveis;
    }
    // Outros métodos
   public void addData(LocalDate data){
        this.datasDisponiveis.add(data);
   }
}
