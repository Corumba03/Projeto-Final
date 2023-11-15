package usuarios;

import pacotesViagem.pacotes.PacoteViagem;

import java.util.List;


public class Usuario {
    private final String cpf;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private List<PacoteViagem> pacotesViagem;
    private int tipoPacote;

    public Usuario(String cpf, String nome, String login, String senha, String email, int tipoPacote) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipoPacote = tipoPacote;
    }

    public String getNome() { return nome; }

    public String getLogin() { return login; }

    public String getSenha() { return senha; }

    public String getEmail() { return email; }

    public String getCpf() { return cpf; }

    public int getTipoPacote() { return tipoPacote; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // TODO adicionar exception: pacotesViagemInexistenteException
    public void adicionarPacote(PacoteViagem pacote){
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
