package usuarios;

public class Admin extends Usuario {

    public Admin(String cpf, String nome, String login, String senha, String email, int tipoPacote) {
        super(cpf, nome, login, senha, email, tipoPacote);
    }

    public void adicionarUsuario(Usuario usuario){
        // TODO criar usuario a partir do objeto usuario
    }
    
    public void editarUsuario(Usuario usuario) {
        // TODO fazer switch case para decidir qual dado de qual usuario alterar
    }
}
