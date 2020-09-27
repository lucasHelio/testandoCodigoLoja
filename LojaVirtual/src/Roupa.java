public class Roupa extends Produto {
    private final char tamanho;
    private final String cor;


    public Roupa(int pesoEmGramas, float precoEmReais, int quantidadeEmEstoque, String cor, char tamanho) {
        super(pesoEmGramas,precoEmReais, "Vestuário", quantidadeEmEstoque);
        this.cor = cor;
        this.tamanho = tamanho;

    }
    public char getTamanho() {
        return tamanho;
    }
    public String getCor() {
        return cor;
    }
    @Override
    public String toString() {
        String categoriaRoupa="Vestuário";
        return String.format("Roupa %s, de tamanho %c, no valor de R$ %.2f, tem %d gramas e se enquadra na classe %s.",
                this.cor, this.tamanho, this.precoEmReais, getPesoEmGramas(), categoriaRoupa);
    }
}