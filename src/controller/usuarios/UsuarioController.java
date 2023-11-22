package controller.usuarios;

import java.util.List;

import model.pacotesViagem.pacotes.PacoteViagemModel;


public class UsuarioController {
    private final String cpf;
    private String nome;
    private char[] senha;
    private String email;
    private List<PacoteViagemModel> pacotesViagem;
    private int tipoPacote;

    public UsuarioController(String cpf, String nome, char[] senha, String email, int tipoPacote) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipoPacote = tipoPacote;
    }

    public String getNome() { return nome; }

    public char[] getSenha() { return senha; }

    public String getEmail() { return email; }

    public String getCpf() { return cpf; }

    public int getTipoPacote() { return tipoPacote; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoPacote(int tipoPacote) {
        this.tipoPacote = tipoPacote;
    }

    // TODO adicionar exception: pacotesViagemInexistenteException
    public void adicionarPacote(PacoteViagemModel pacote){
        pacotesViagem.add(pacote);
    }

    // TODO adicionar exception: OperacaoNaoRealizadaException
    // Excessao para operacoes no banco de dados
    public void deletarConta(){
        // TODO chamada de userConnection para deletar conta do banco de dados
    }

    public void editarDado(){
        // TODO switch case para verificar qual dado o usuario deseja alterar
        // Fazer chamada de userConnection para editar usuario no db
    }
}
