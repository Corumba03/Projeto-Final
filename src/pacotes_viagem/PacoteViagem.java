package pacotes_viagem;

import Exceptions.CategoriaInexistenteException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacoteViagem {
    private String categoria; // A categoria (Aventura, Relaxamento, Cultura, etc) do pacote
    private Set<Atividade> atividades;
    private Set<LocalDate> datasDisponiveis;
    private List<Avaliacao> avaliacoes; // Lista de avaliações/comentários de turistas sobre o pacote
    private String precoBase;

    public PacoteViagem(String categoria, String precoBase) {
        try {
            if (!Categorias.getCategorias().contains(categoria)){
                throw new CategoriaInexistenteException("Categoria não consta no sistema");
            }
            this.categoria = categoria;
        }
        catch (CategoriaInexistenteException e){
            System.err.println("Erro ao criar pacote de viagem: " + e.getMessage());
        }
        this.precoBase = precoBase;
        this.atividades = new HashSet<>();
        this.datasDisponiveis = new HashSet<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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

    public String getPrecoBase() {
        return precoBase;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setPrecoBase(String precoBase) {
        this.precoBase = precoBase;
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
