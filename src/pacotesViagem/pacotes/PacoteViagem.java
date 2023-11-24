package pacotesViagem.pacotes;

import Exceptions.CategoriaInexistenteException;
import pacotesViagem.Atividade;
import pacotesViagem.Avaliacao;
import pacotesViagem.Viagem;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class  PacoteViagem {
    private Categorias categoria; // A categoria (Aventura, Relaxamento, Cultura, etc) do pacote
    protected PlanoPacote plano; // Premium, Basico, Lite
    private Viagem viagem; // Destino da viagem
    private Set<Atividade> atividades; // Lista de atividades inclusas no pacote
    private Set<LocalDate> datasDisponiveis; // Lista de datas disponíveis para o pacote
    private List<Avaliacao> avaliacoes; // Lista de avaliações/comentários de turistas sobre o pacote
    private double precoBase;
    private double descontoBase; // Desconto percentual base (é convertido para decimal)

    public PacoteViagem(Categorias categoria, double descontoBase) {
        this.precoBase = 0.0; // Preço será definido pelo preço do destino e das atividades
        this.atividades = new HashSet<>();
        this.datasDisponiveis = new HashSet<>();
        this.plano = PlanoPacote.Basico;
        this.descontoBase = descontoBase / 100;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public Set<LocalDate> getDatasDisponiveis() {
        return datasDisponiveis;
    }

    public void setDatasDisponiveis(Set<LocalDate> datasDisponiveis) {
        this.datasDisponiveis = datasDisponiveis;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public PlanoPacote getPlano() {
        return plano;
    }

    public void setPlano(PlanoPacote plano) {
        this.plano = plano;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public double getDescontoBase() {
        return descontoBase;
    }

    public void setDescontoBase(double descontoBase) {
        this.descontoBase = descontoBase;
    }

    // Outros métodos

    public void atualizarPreco(){
        double preco_atividades = 0.0;
        for (Atividade atividade : this.atividades){
            preco_atividades += atividade.getPreco();
        }
        this.precoBase = (this.viagem.getPreco() + preco_atividades) * (1 - this.descontoBase); // Preço da passagem + preço das atividades - descontos
    }

    public void addAvaliacao(Avaliacao avaliacao){
        this.avaliacoes.add(avaliacao);
    }
    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }
    public void removerAtividade(Atividade atividade){
        try {
            if (!this.atividades.contains(atividade)){
                throw new IllegalArgumentException("Atividade não faz parte do pacote");
            }
            this.atividades.remove(atividade);
        }
        catch (IllegalArgumentException e){
            System.out.println("Erro ao remover atividade: " + e.getMessage());
        }
    }
    public void addData(LocalDate data){
        this.datasDisponiveis.add(data);
    }
    public void removerData(LocalDate data){
        try {
            if (!this.datasDisponiveis.contains(data)){
                throw new IllegalArgumentException("Data não está disponível no pacote");
            }
            this.datasDisponiveis.remove(data);
        }
        catch (IllegalArgumentException e){
            System.out.println("Erro ao remover data: " + e.getMessage());
        }
    }

}
