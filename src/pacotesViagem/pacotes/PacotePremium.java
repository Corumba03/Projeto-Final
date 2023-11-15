package pacotesViagem.pacotes;

public class PacotePremium extends PacoteViagem{
    private static double premiumLimitePreco; // Limite inferior de preço
    private static int premiumLimiteAtividades; // Limite superior de atividades por dia

    public PacotePremium(String categoria, Double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacote.Premium;
    }

    public static double getPremiumLimitePreco() {
        return premiumLimitePreco;
    }

    public static void setPremiumLimitePreco(double premiumLimitePreco) {
        PacotePremium.premiumLimitePreco = premiumLimitePreco;
    }

    public static int getPremiumLimiteAtividades() {
        return premiumLimiteAtividades;
    }

    public static void setPremiumLimiteAtividades(int premiumLimiteAtividades) {
        PacotePremium.premiumLimiteAtividades = premiumLimiteAtividades;
    }
}
