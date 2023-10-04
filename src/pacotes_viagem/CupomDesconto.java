package pacotes_viagem;

public class CupomDesconto {
    private double desconto; // Valor percentual do desconto (o valor é convertido para decimal)
    private boolean aditivo; // Atributo para indicar se o desconto é aditivo ou cumulativo
    private double precoMinimo; // Preço minímo para que o cupom seja elegível
    private double descontoMaximo; // Valor máximo que o cupom consegue descontar

    public CupomDesconto(double desconto, boolean aditivo, double precoMinimo, double descontoMaximo) {
        this.desconto = desconto;
        this.aditivo = aditivo;
        this.precoMinimo = precoMinimo;
        this.descontoMaximo = descontoMaximo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public boolean isAditivo() {
        return aditivo;
    }

    public void setAditivo(boolean aditivo) {
        this.aditivo = aditivo;
    }

    public double getPrecoMinimo() {
        return precoMinimo;
    }

    public void setPrecoMinimo(double precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }
}
