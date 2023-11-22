package model.pacotesViagem.pacotes;

public class PacoteBasicoModel extends PacoteViagemModel{
    private static double basicoLimitePreco; // Limite inferior de preço
    private static int basicoLimiteAtividades; // Limite superior de atividades por dia
    public PacoteBasicoModel(String categoria, double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacoteModel.Basico;
    }

    public static double getBasicoLimitePreco() {
        return basicoLimitePreco;
    }

    public static void setBasicoLimitePreco(double basicoLimitePreco) {
        PacoteBasicoModel.basicoLimitePreco = basicoLimitePreco;
    }

    public static int getBasicoLimiteAtividades() {
        return basicoLimiteAtividades;
    }

    public static void setBasicoLimiteAtividades(int basicoLimiteAtividades) {
        PacoteBasicoModel.basicoLimiteAtividades = basicoLimiteAtividades;
    }
}
