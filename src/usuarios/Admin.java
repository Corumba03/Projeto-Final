package usuarios;

public class Admin extends Usuario {

    public Admin(String cpf, String nome, String senha, String email, String login, int tipoPacote) {
        super(cpf, nome, senha, email, login, tipoPacote);
    }

    public void adicionarUsuario(Usuario usuario){
        // TODO criar usuario a partir do objeto usuario
    }
    
    public void editarUsuario(Usuario usuario) {
        // TODO fazer switch case para decidir qual dado de qual usuario alterar
    }
}
