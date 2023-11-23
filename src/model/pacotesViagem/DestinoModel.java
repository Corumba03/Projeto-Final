package model.pacotesViagem;

import java.time.Duration;

public class DestinoModel {
    private String nome; // Nome do local de destino da viagem
    private String info; // Informações gerais sobre o destino (clima, idioma, cultura, etc)

    public DestinoModel(String nome, String resumo, String desc, Duration duracao, double preco, String info) {
        this.nome = nome;
        this.info = info;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
}
