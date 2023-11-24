import java.util.List;

import controller.usuarios.UsuarioController;
import model.conexao.ConexaoModelImpl;
import model.conexao.UserConnectionModelImpl;


public class Main {
    public static void main(String[] args) {
        // Tela tela = Tela.getInstance(800, 1000);
        
        ConexaoModelImpl conn = new ConexaoModelImpl();
        UserConnectionModelImpl.setConexao(conn.getConexao());
        List<UsuarioController> us = UserConnectionModelImpl.listarUsuarios();
        for (UsuarioController u : us){
            System.err.println(u.getCpf() + ": " + u.getNome());
        }
    }
}