package pacotesViagem.pacotes;

public class PacoteLite extends PacoteViagem{
    private static double liteLimitePreco; // Limite SUPERIOR de preço
    private static int liteLimiteAtividades; // Limite superior de atividades por dia

    public PacoteLite(Categorias categoria, Double precoBase) {
        super(categoria, precoBase);
        this.plano = PlanoPacote.Lite;
    }

    public static double getLiteLimitePreco() {
        return liteLimitePreco;
    }

    public static void setLiteLimitePreco(double liteLimitePreco) {
        PacoteLite.liteLimitePreco = liteLimitePreco;
    }

    public static int getLiteLimiteAtividades() {
        return liteLimiteAtividades;
    }

    public static void setLiteLimiteAtividades(int liteLimiteAtividades) {
        PacoteLite.liteLimiteAtividades = liteLimiteAtividades;
    }
}
