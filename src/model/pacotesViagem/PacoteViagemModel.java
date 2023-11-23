package model.pacotesViagem;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import controller.exceptions.CategoriaInexistenteException;

public abstract class  PacoteViagemModel {
    private String categoria; // A categoria (Aventura, Relaxamento, Cultura, etc) do pacote
    protected PlanoPacoteModel plano; // Premium, Basico, Lite
    private ViagemModel viagem; // Destino da viagem
    private Set<AtividadeModel> atividades; // Lista de atividades inclusas no pacote
    private Set<LocalDate> datasDisponiveis; // Lista de datas disponíveis para o pacote
    private List<String> avaliacoes; // Lista de avaliações/comentários de turistas sobre o pacote
    private double precoBase;
    private double descontoBase; // Desconto percentual base (é convertido para decimal)

    public PacoteViagemModel(String categoria, double descontoBase) {
        try {
            for (CategoriaDestinoModel c : CategoriaDestinoModel.values()){
                if (c.name().equals(categoria)){
                    this.categoria = categoria;
                }else{
                    throw new CategoriaInexistenteException("Categoria não consta no sistema");
                }
            }
        }
        catch (CategoriaInexistenteException e){
            System.err.println("Erro ao criar pacote de viagem: " + e.getMessage());
        }
        this.precoBase = 0.0; // Preço será definido pelo preço do destino e das atividades
        this.atividades = new HashSet<>();
        this.datasDisponiveis = new HashSet<>();
        this.plano = PlanoPacoteModel.Basico;
        this.descontoBase = descontoBase / 100;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<AtividadeModel> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<AtividadeModel> atividades) {
        this.atividades = atividades;
    }

    public Set<LocalDate> getDatasDisponiveis() {
        return datasDisponiveis;
    }

    public void setDatasDisponiveis(Set<LocalDate> datasDisponiveis) {
        this.datasDisponiveis = datasDisponiveis;
    }

    public List<String> getAvaliacoes(){
        return avaliacoes;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public PlanoPacoteModel getPlano() {
        return plano;
    }

    public void setPlano(PlanoPacoteModel plano) {
        this.plano = plano;
    }

    public ViagemModel getViagem() {
        return viagem;
    }

    public void setViagem(ViagemModel viagem) {
        this.viagem = viagem;
    }

    public double getDescontoBase() {
        return descontoBase;
    }

    public void setDescontoBase(double descontoBase) {
        this.descontoBase = descontoBase;
    }


    // Outros métodos

    // public void atualizarPreco(){
    //     double preco_atividades = 0.0;
    //     for (AtividadeModel atividade : this.atividades){
    //         preco_atividades += atividade.getPreco();
    //     }
    //     this.precoBase = (this.viagem.getPreco() + preco_atividades) * (1 - this.descontoBase); // Preço da passagem + preço das atividades - descontos
    // }

    public void addAtividade(AtividadeModel atividade){
        this.atividades.add(atividade);
    }
    public void removerAtividade(AtividadeModel atividade){
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
