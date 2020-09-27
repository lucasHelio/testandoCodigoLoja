public class Produto{
    private final int pesoEmGramas;
    protected float precoEmReais;
    private final String categoria;
    public int quantidadeEmEstoque;
    private static long nextSeqNum = 1;
    protected final long id;  // identificador único (sequencial) deste objeto


    public Produto(int pesoEmGramas, float precoEmReais, String categoria,int quantidadeEmEstoque) {
        this.id = nextSeqNum++;
        this.pesoEmGramas = pesoEmGramas;
        this.precoEmReais = precoEmReais;
        this.categoria=categoria;
        this.quantidadeEmEstoque=quantidadeEmEstoque;

    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }



    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public long getId() {
        return this.id;
    }
}