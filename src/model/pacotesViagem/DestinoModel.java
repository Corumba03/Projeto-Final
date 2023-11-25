package model.pacotesViagem;

public class DestinoModel {
    private String nome; // Nome do local de destino da viagem
    private String info; // Informações gerais sobre o destino (clima, idioma, cultura, etc)
    private AtividadeModel atividade;

    public DestinoModel(String nome, String info, AtividadeModel atividade) {
        this.nome = nome;
        this.info = info;
        this.atividade = atividade;
    }

    // Getters e setters
    public String getNome() { return nome; }

    public String getInfo() { return info; }

    public AtividadeModel getAtividade() { return atividade; }
}
