package controller.usuarios;

public class AdminController extends UsuarioController {

    public AdminController(String cpf, String nome, char[] senha, String email, int tipoPacote) {
        super(cpf, nome, senha, email);
    }

    public void adicionarUsuario(UsuarioController usuario){
        // TODO criar usuario a partir do objeto usuario
    }
    
    public void editarUsuario(UsuarioController usuario) {
        // TODO fazer switch case para decidir qual dado de qual usuario alterar
    }
}
