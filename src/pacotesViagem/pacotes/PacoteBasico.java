package pacotesViagem.pacotes;

public class PacoteBasico extends PacoteViagem{
    private static double basicoLimitePreco; // Limite inferior de preço
    private static int basicoLimiteAtividades; // Limite superior de atividades por dia
    public PacoteBasico(Categorias categoria, double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacote.Basico;
    }

    public static double getBasicoLimitePreco() {
        return basicoLimitePreco;
    }

    public static void setBasicoLimitePreco(double basicoLimitePreco) {
        PacoteBasico.basicoLimitePreco = basicoLimitePreco;
    }

    public static int getBasicoLimiteAtividades() {
        return basicoLimiteAtividades;
    }

    public static void setBasicoLimiteAtividades(int basicoLimiteAtividades) {
        PacoteBasico.basicoLimiteAtividades = basicoLimiteAtividades;
    }
}
