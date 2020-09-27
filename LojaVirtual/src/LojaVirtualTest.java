import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class LojaVirtualTest {
    private Produto produto1;
    private Livro livro1;
    private Roupa roupa1;
    private LojaVirtual lojaVirtual;


    @Before
    public void setUp(){
        lojaVirtual = new LojaVirtual();
        livro1= new Livro(12,10,10,"As estrelas","Haary John",2004,450);
        roupa1=new Roupa (6,15,5,"Amarelo",'p');
        produto1 = new Produto(10, 30, "Publicações", 25);
    }

    @Test
    public void testarIncluirProdutoNoEstoque() {
        lojaVirtual.incluirProdutoNoEstoque(livro1, 1);
        assertEquals("O estoque da loja deve ser 10 após a inclusão de 1 livro1", 10, lojaVirtual.getTamanhoEstoque(),0);
        assertEquals("O estoque do produto deve ser 1 após a inclusão de 1 produto",10, lojaVirtual.getTamanhoEstoque(livro1));

        lojaVirtual.incluirProdutoNoEstoque(roupa1, 1);
        assertEquals("O estoque da loja deve ser 2 após a inclusão de mais 1 produto",15, lojaVirtual.getTamanhoEstoque(),0);
        assertEquals("O estoque do produto deve ser 1 após a inclusão de 1 produto",5, lojaVirtual.getTamanhoEstoque(roupa1));

        lojaVirtual.incluirProdutoNoEstoque(roupa1, 5);
        assertEquals("O estoque da loja deve ser 7 após a inclusão de mais 5 produtos", 40, lojaVirtual.getTamanhoEstoque(),0);
        assertEquals("O estoque do produto deve ser 6 após a inclusão de mais 5 produtos", 30, lojaVirtual.getTamanhoEstoque(roupa1));


    }
    @Test
    public void removerProdutoEstoqueTest(){
        lojaVirtual.incluirProdutoNoEstoque(livro1, 1);
        lojaVirtual.incluirProdutoNoEstoque(roupa1, 2);
        assertEquals("espero ter 20 itens em estoque",20, lojaVirtual.getTamanhoEstoque());
        assertEquals("espero encontrar 10 livros1",10, lojaVirtual.getTamanhoEstoque(livro1));
        assertEquals("espero encontrar 10 roupa1",10, lojaVirtual.getTamanhoEstoque(roupa1));
        lojaVirtual.removerProdutoEstoque(livro1, 5);
        assertEquals(5, lojaVirtual.getTamanhoEstoque(livro1));
        lojaVirtual.removerProdutoEstoque(roupa1, 3);
        assertEquals("Espero encontrar 7 roupas no estoque",7, lojaVirtual.getTamanhoEstoque(roupa1));

    }


    @Test
    public void getTamanhoEstoqueTest() {
        //produto1 = new Produto(10, 30, "Publicações", 25); coloquei no construtor
        int quantidadeEmEstoque = produto1.getQuantidadeEmEstoque();
        assertEquals("A quantidade de produtos em estoque é: ",
                25, quantidadeEmEstoque, 0);
    }

    @Test
    public void efetuarVendaTest() {
        int quantidade=5;
        lojaVirtual.incluirProdutoNoEstoque(produto1, 1); //adicionei produto1 na loja (25 em estoque)
        lojaVirtual.efetuarVenda(produto1, quantidade); // aqui que começa a dar blayde
        float valorDaCompra = produto1.getPrecoEmReais() * quantidade;
        //float totalDeVendas = +valorDaCompra;
        //int totalItens=produto1.getQuantidadeEmEstoque();
        //totalItens-=quantidade;
        assertEquals("O valor da compra foi recebido", 150, valorDaCompra,0);
        assertEquals("O valor total de vendas",150,lojaVirtual.getTotalValorVendas(),0);
        assertEquals("Quantidade de produtos no estoque após a venda",20, lojaVirtual.getTamanhoEstoque(),0);
    }
}