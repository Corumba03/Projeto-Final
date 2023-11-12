// import java.util.HashSet;
// import java.util.Set;

import conexao.ConexaoImpl;
import conexao.UserConnectionImpl;

public class Main {
    public static void main(String[] args) {

        ConexaoImpl conn = new ConexaoImpl();
        UserConnectionImpl user = new UserConnectionImpl(conn.getConexao());
        user.consultarDados(2);
        user.consultarDestinos(2);
    }
}