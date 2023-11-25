import java.util.List;

import controller.PacoteViagemController;
import model.conexao.ConexaoModel;
import model.conexao.PacoteViagemConnectionModel;
import model.pacotesViagem.CategoriaDestinoModel;

public class Main {
    public static void main(String[] args) {
        // Tela tela = Tela.getInstance(800, 1000);

        ConexaoModel.iniciarConexao();
        List<PacoteViagemController> pacotes = PacoteViagemConnectionModel.buscarPacotePorDestino("Paris");
        for (PacoteViagemController p : pacotes){
            System.out.println("Plano: " + p.getPlano());
        }
        ConexaoModel.encerrarConexao();
    }
}