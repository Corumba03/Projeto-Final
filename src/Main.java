import java.util.List;

import controller.PacoteViagemController;
import model.conexao.ConexaoModel;
import model.conexao.PacoteViagemConnectionModel;

public class Main {
    public static void main(String[] args) {
        // Tela tela = Tela.getInstance(800, 1000);

        ConexaoModel.iniciarConexao();
        List<PacoteViagemController> pacotes = PacoteViagemConnectionModel.buscarPacotePorPrecoMax(500);
        for (PacoteViagemController p : pacotes){
            System.out.println("Destino: " + p.getDestino().getNome());
        }
        ConexaoModel.encerrarConexao();
    }
}