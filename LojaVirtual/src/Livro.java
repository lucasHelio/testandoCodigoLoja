public class Livro extends Produto {

    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private final int numeroDePaginas;

    public Livro(int pesoEmGramas, float precoEmReais, int quantidadeEmEstoque, String titulo, String autor, int anoDePublicacao, int numeroDePaginas) {
        super(pesoEmGramas, precoEmReais,"Publicações", quantidadeEmEstoque);
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    @Override
    public String toString() {
        String categoriaLivro ="Publicações";
        return String.format("Livro %s, do autor %s, contendo %d paginas, publicado no ano de %d e se enquadra na categoria %s",
                this.titulo, this.autor, this.numeroDePaginas, this.anoDePublicacao, categoriaLivro);

    }

}