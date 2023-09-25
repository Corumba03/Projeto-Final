package destinos;

public class Destino {
    private String nome; // Nome do locad de destino da viagem
    private String duracao; // Duração da viagem // TODO implementar com um tipo mais adequado
    private String preco; // Custo da viagem // TODO implementar com um tipo mais adequado

    public Destino(String nome, String duracao, String preco) {
        this.nome = nome;
        this.duracao = duracao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
