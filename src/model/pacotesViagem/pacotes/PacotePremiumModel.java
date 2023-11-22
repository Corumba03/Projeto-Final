package model.pacotesViagem.pacotes;

public class PacotePremiumModel extends PacoteViagemModel{
    private static double premiumLimitePreco; // Limite inferior de preço
    private static int premiumLimiteAtividades; // Limite superior de atividades por dia

    public PacotePremiumModel(String categoria, Double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacoteModel.Premium;
    }

    public static double getPremiumLimitePreco() {
        return premiumLimitePreco;
    }

    public static void setPremiumLimitePreco(double premiumLimitePreco) {
        PacotePremiumModel.premiumLimitePreco = premiumLimitePreco;
    }

    public static int getPremiumLimiteAtividades() {
        return premiumLimiteAtividades;
    }

    public static void setPremiumLimiteAtividades(int premiumLimiteAtividades) {
        PacotePremiumModel.premiumLimiteAtividades = premiumLimiteAtividades;
    }
}
