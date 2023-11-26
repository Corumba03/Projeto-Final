import controller.PacoteViagemController;
import controller.usuarios.UsuarioController;
import model.conexao.ConexaoModel;
import model.conexao.PacoteViagemConnectionModel;
import model.conexao.UserConnectionModelImpl;

public class Main {
    public static void main(String[] args) {
        // Tela tela = Tela.getInstance(800, 1000);

        // Iniciando conexao com o banco de dados
        ConexaoModel.iniciarConexao();

        // Encerrando conexao com o banco de dados
        ConexaoModel.encerrarConexao();
    }
}