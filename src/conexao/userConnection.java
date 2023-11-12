package conexao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usuarios.Usuario;

interface UserConnection{

    Map<String, String> dados = new HashMap<>();

    // Consulta dados referentes ao proprio usuario
    public Map<String, String> consultarDados(int id);

    // Consulta destinos que o usuario referente ao id possui
    public Map<String, String> consultarDestinos(int id);

    // Cria conta para o usuario no sistema
    void criarUsuario(Usuario usuario);

    // Remove a conta do usuario do sistema
    void removerUsuario(int id);

    // Edita determinado campo de determinado usuario com determinado dado
    void editarUsuario(int id, String campo, String dado);

    List<Usuario> listarUsuarios();
}
