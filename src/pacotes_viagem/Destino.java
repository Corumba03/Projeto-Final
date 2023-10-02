package pacotes_viagem;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Destino {
    private String nome; // Nome do local de destino da viagem
    private String resumo; // Descrição breve da viagem
    private String desc; // Descrição detalhada da viagem
    private Set<Atracao> atracoes; // Lista de atrações do local de destino
    private Set<PontoTuristico> pontosTuristicos; // Lista dos principais pontos turísticos
    private List<Avaliacao> avaliacoes; // Lista de avaliações/comentários de turistas sobre o destino
    private String info; // Informações gerais sobre o destino (clima, idioma, cultura, etc)
    private Duration duracao; // Duração da viagem em dias
    private String preco; // Custo da viagem // TODO implementar com um tipo mais adequado

    public Destino(String nome, String resumo, String desc, Duration duracao, String preco, String info) {
        this.nome = nome;
        this.resumo = resumo;
        this.desc = desc;
        this.info = info;
        this.duracao = duracao;
        this.preco = preco;
        this.atracoes = new HashSet<>();
        this.pontosTuristicos = new HashSet<>();
        this.avaliacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = Duration.ofDays(duracao);
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Atracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(Set<Atracao> atracoes) {
        this.atracoes = atracoes;
    }

    public Set<PontoTuristico> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(Set<PontoTuristico> pontoTuristicos) {
        this.pontosTuristicos = pontoTuristicos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    // Outros métodos

    public void addAtracao(Atracao atracao){
        this.atracoes.add(atracao);
    }

    public void removerAtracao(Atracao atracao){
        try {
            if (!this.atracoes.contains(atracao)){
                throw new IllegalArgumentException("Atração não faz parte do destino");
            }
            this.atracoes.remove(atracao);
        }catch (IllegalArgumentException e){
            System.err.println("Erro ao remover atração: " + e.getMessage());
        }
    }

    public void removerPontoTuristico(PontoTuristico pontoTuristico){
        try {
            if (!this.pontosTuristicos.contains(pontoTuristico)){
                throw new IllegalArgumentException("Ponto turístico não faz parte do destino");
            }
            this.pontosTuristicos.remove(pontoTuristico);
        }catch (IllegalArgumentException e){
            System.err.println("Erro ao remover ponto turístico: " + e.getMessage());
        }
    }
    public void addAvaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }
    public void addPontoTuristico(PontoTuristico pontoTuristico){
        this.pontosTuristicos.add(pontoTuristico);
    }
    public void extenderDuracao(int numDias){
        this.duracao = duracao.plusDays(numDias);
    }
}
