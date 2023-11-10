package usuarios;

public class Admin extends Usuario {

    public Admin(String nome, String login, String senha, String email) {
        super(nome, login, senha, email);
    }

    public void adicionarUsuario(Usuario usuario){
        // TODO criar usuario a partir do objeto usuario
    }
    
    public void editarUsuario(Usuario usuario) {
        // TODO fazer switch case para decidir qual dado de qual usuario alterar
    }
}
