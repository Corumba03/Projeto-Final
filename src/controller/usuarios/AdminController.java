package controller.usuarios;

public class AdminController extends UsuarioController {

    public AdminController(String cpf, String nome, char[] senha, String email) {
        super(cpf, nome, senha, email);
    }

    public static void adicionarPacote(){}
    public static void editarPacote(){}
    public static void removerPacote(){}

}
