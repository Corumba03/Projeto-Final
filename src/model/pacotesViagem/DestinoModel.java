package model.pacotesViagem;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinoModel {
    private String nome; // Nome do local de destino da viagem
    private Set<AtracaoModel> atracoes; // Lista de atrações do local de destino
    private Set<PontoTuristicoModel> pontosTuristicos; // Lista dos principais pontos turísticos
    private List<AvaliacaoModel> avaliacoes; // Lista de avaliações/comentários de turistas sobre o destino
    private String info; // Informações gerais sobre o destino (clima, idioma, cultura, etc)
    private double preco; // Custo da viagem

    public DestinoModel(String nome, String resumo, String desc, Duration duracao, double preco, String info) {
        this.nome = nome;
        this.info = info;
        this.preco = preco;
        this.atracoes = new HashSet<>();
        this.pontosTuristicos = new HashSet<>();
        this.avaliacoes = new ArrayList<>();
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public Set<AtracaoModel> getAtracoes() { return atracoes; }
    public void setAtracoes(Set<AtracaoModel> atracoes) { this.atracoes = atracoes; }

    public Set<PontoTuristicoModel> getPontosTuristicos() { return pontosTuristicos; }
    public void setPontosTuristicos(Set<PontoTuristicoModel> pontoTuristicos) { this.pontosTuristicos = pontoTuristicos; }

    public List<AvaliacaoModel> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) { this.avaliacoes = avaliacoes; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    // Outros métodos
    public void addAtracao(AtracaoModel atracao){
        this.atracoes.add(atracao);
    }

    public void removerAtracao(AtracaoModel atracao){
        try {
            if (!this.atracoes.contains(atracao)){
                throw new IllegalArgumentException("Atração não faz parte do destino");
            }
            this.atracoes.remove(atracao);
        }catch (IllegalArgumentException e){
            System.err.println("Erro ao remover atração: " + e.getMessage());
        }
    }

    public void removerPontoTuristico(PontoTuristicoModel pontoTuristico){
        try {
            if (!this.pontosTuristicos.contains(pontoTuristico)){
                throw new IllegalArgumentException("Ponto turístico não faz parte do destino");
            }
            this.pontosTuristicos.remove(pontoTuristico);
        }catch (IllegalArgumentException e){
            System.err.println("Erro ao remover ponto turístico: " + e.getMessage());
        }
    }
    public void addAvaliacao(AvaliacaoModel avaliacao){
        this.avaliacoes.add(avaliacao);
    }
    public void addPontoTuristico(PontoTuristicoModel pontoTuristico){
        this.pontosTuristicos.add(pontoTuristico);
    }
}
