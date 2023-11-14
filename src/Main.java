// import java.util.HashSet;
// import java.util.Set;

import java.util.List;

import conexao.ConexaoImpl;
import conexao.UserConnectionImpl;
import usuarios.Usuario;

public class Main {
    public static void main(String[] args) {

        
        ConexaoImpl conn = new ConexaoImpl();
        UserConnectionImpl.setConexao(conn.getConexao());
        // Usuario user = new Usuario("55522244465", "Carlos Alberto", "olhoporolho", "123456", "Carlin@gmail.com", 1);
        // System.out.println(user.getNome().getClass());
        // UserConnectionImpl.criarUsuario(user);
        // UserConnectionImpl.removerUsuario("55522244465");
        // List<Usuario> usuarios = UserConnectionImpl.listarUsuarios();
        // for(Usuario u : usuarios){
        //     System.out.println(u.getCpf() + ": " + u.getNome());
        // }
    }
}