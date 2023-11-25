package model.pacotesViagem;

public class AtividadeModel {
    
    private String nome; // Nome da atividade
    private String resumo; // Descrição breve da atividade
    private String desc; // Descrição detalhada da atividade
    private String duracao; // Duração prevista da atividade
    private DificuldadeModel dificuldade; // Dificuldade da atividade
    private String disponibilidade; 
    private String cuidados; //Restrições e cuidados da atividade
    private String equipamentos; // Lista de equipamentos necessários

    public AtividadeModel(String nome, String resumo, String desc, String duracao, DificuldadeModel dificuldade, String disponibilidade, String cuidados, String equipamentos) {
        this.nome = nome;
        this.resumo = resumo;
        this.desc = desc;
        this.dificuldade = dificuldade;
        this.duracao = duracao;
        this.disponibilidade = disponibilidade;
        this.cuidados = cuidados;
        this.equipamentos = equipamentos;
    }

    public String getNome() {
        return nome;
    }

    public String getResumo() {
        return resumo;
    }

    public String getDesc() {
        return desc;
    }

    public String getDuracao() {
        return duracao;
    }

    public DificuldadeModel getDificuldade() {
        return dificuldade;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public String getCuidados() {
        return cuidados;
    }

    public String getEquipamentos() {
        return equipamentos;
    }

}
