package usuarios;

import java.util.List;
import pacotes_viagem.PacoteViagem;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private String email;
    private List<PacoteViagem> pacotesViagem;

    public Usuario(String nome, String login, String senha, String email) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() { return nome; }

    public String getLogin() { return login; }

    public String getSenha() { return senha; }

    public String getEmail() { return email; }


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
