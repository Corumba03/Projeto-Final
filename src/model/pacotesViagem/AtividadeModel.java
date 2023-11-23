package model.pacotesViagem;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AtividadeModel {
    public enum Dificuldade{
        Facil, Moderado, Dificil, Perigoso
    }
    private String nome; // Nome da atividade
    private String resumo; // Descrição breve da atividade
    private String desc; // Descrição detalhada da atividade
    private Duration duracao; // Duração prevista da atividade
    private Dificuldade dificuldade; // Dificuldade da atividade
    private String disponibilidade; // Informações sobre quando a atividade está disponível (por exemplo, duranto o ano, apenas no verão). TODO implementar com um tipo melhor
    private String cuidados; //Restrições e cuidados da atividade
    private List<String> equipamentos; // Lista de equipamentos necessários
    // private double preco; // Preço da atividade

    public AtividadeModel(String nome, String resumo, String desc, Dificuldade dificuldade, Duration duracao, String disponibilidade, String cuidados, double preco) {
        this.nome = nome;
        this.resumo = resumo;
        this.desc = desc;
        this.dificuldade = dificuldade;
        this.duracao = duracao;
        this.disponibilidade = disponibilidade;
        this.cuidados = cuidados;
        this.equipamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public List<String> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<String> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
    // Outros métodos
    public void addEquipamento(String equipamento){
        this.equipamentos.add(equipamento);
    }
    public void removeEquipamento(String equipamento){
        this.equipamentos.remove(equipamento);
    }
}
