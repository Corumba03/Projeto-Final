package model.pacotesViagem.pacotes;

public class PacoteLiteModel extends PacoteViagemModel{
    private static double liteLimitePreco; // Limite SUPERIOR de preço
    private static int liteLimiteAtividades; // Limite superior de atividades por dia

    public PacoteLiteModel(String categoria, Double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacoteModel.Lite;
    }

    public static double getLiteLimitePreco() {
        return liteLimitePreco;
    }

    public static void setLiteLimitePreco(double liteLimitePreco) {
        PacoteLiteModel.liteLimitePreco = liteLimitePreco;
    }

    public static int getLiteLimiteAtividades() {
        return liteLimiteAtividades;
    }

    public static void setLiteLimiteAtividades(int liteLimiteAtividades) {
        PacoteLiteModel.liteLimiteAtividades = liteLimiteAtividades;
    }
}
