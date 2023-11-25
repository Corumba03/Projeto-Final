package controller.usuarios;

import java.util.List;

import controller.PacoteViagemController;
import model.conexao.PacoteViagemConnectionModel;
import model.conexao.UserConnectionModelImpl;
import model.pacotesViagem.CategoriaDestinoModel;


public class UsuarioController {
    private final String cpf;
    private String nome;
    private char[] senha;
    private String email;
    private List<PacoteViagemController> pacotesViagem;
    // private int tipoPacote;

    public UsuarioController(String cpf, String nome, char[] senha, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        // this.tipoPacote = tipoPacote;
    }


    // Getters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public char[] getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public List<PacoteViagemController> getPacotesViagem() {
        return pacotesViagem;
    }

    // Outros metodos
    public void cadastrarUsuario(){
        UserConnectionModelImpl.criarUsuario(this);
    }

    public static UsuarioController verificaUsuario(String email, String senha){
        return UserConnectionModelImpl.verificaUsuario(email, senha);
    }

    // TODO
    public void adicionarPacote(PacoteViagemController pacote){}
    public void consultarDestinos(String destino){}
    
    public List<PacoteViagemController> buscarPacotePorDestino(String destino){
        return PacoteViagemConnectionModel.buscarPacotePorDestino(destino);
    }
    public List<PacoteViagemController> buscarPacotePorCategoria(CategoriaDestinoModel categoria){
        return PacoteViagemConnectionModel.buscarPacotePorCategoria(categoria);
    }
}
