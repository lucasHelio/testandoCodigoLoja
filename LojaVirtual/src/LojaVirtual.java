

import java.util.ArrayList;
public class LojaVirtual {
    private int totalItens;
    private float totalDeVendas;
    private float valorDaCompra;
    private final ArrayList<Produto> itens;

    public LojaVirtual(){
        this.totalItens=0;
        this.itens=new ArrayList<Produto>();
    }

    public void incluirProdutoNoEstoque(Produto produto, int quantidade){
        if(!possuiItem(produto)) { //Caso o produto ainda não esteja no Estoque
            this.itens.add(produto);
            for(Produto itemEstoque : this.itens){
                if(itemEstoque.equals(produto)){
                    this.itens.get(this.itens.indexOf(itemEstoque)).setQuantidadeEmEstoque(this.itens.get(this.itens.indexOf(itemEstoque)).quantidadeEmEstoque = produto.quantidadeEmEstoque*quantidade);
                    totalItens += this.itens.get(this.itens.indexOf(itemEstoque)).getQuantidadeEmEstoque();
                }

            }

            //totalItens+= quantidade * produto.quantidadeEmEstoque;
        }
        else //Produto já existe no estoque
        {   //totalItens+= quantidade * produto.quantidadeEmEstoque;
            adicionaEstoqueProdutoExistente(produto, quantidade);}
        //totalItens+= quantidade * produto.quantidadeEmEstoque;

    }

    public void adicionaEstoqueProdutoExistente(Produto itemDesejado, int quantidade){
        for(Produto itemEstoque : this.itens){
            if(itemEstoque.equals(itemDesejado)){
                totalItens+= quantidade * itemDesejado.quantidadeEmEstoque;
                this.itens.get(this.itens.indexOf(itemEstoque)).setQuantidadeEmEstoque(this.itens.get(this.itens.indexOf(itemEstoque)).quantidadeEmEstoque+(itemDesejado.quantidadeEmEstoque*quantidade));
            }
        }
    }

    public void removerProdutoEstoque(Produto itemDesejado, int quantidade){
        for(Produto itemEstoque : this.itens){
            if(itemEstoque.equals(itemDesejado)){
                this.itens.get(this.itens.indexOf(itemEstoque)).setQuantidadeEmEstoque(this.itens.get(this.itens.indexOf(itemEstoque)).quantidadeEmEstoque-(quantidade));
                totalItens-=quantidade;
            }
        }
    }

    public int getTamanhoEstoque(){
        return totalItens;
    }

    public int getTamanhoEstoque(Produto produto){
        return this.itens.get(this.itens.indexOf(produto)).quantidadeEmEstoque;
    }

    private boolean possuiItem(Produto itemDesejado) {
        for (Produto itemEstoque : this.itens) {
            if (itemEstoque.equals(itemDesejado)) {
                return true;}
        }
        return false;
    }


    public String efetuarVenda(Produto produto, int quantidade){
        if (!possuiItem(produto) || quantidade> this.itens.get(this.itens.indexOf(produto)).quantidadeEmEstoque){
            return null;}
        valorDaCompra = produto.getPrecoEmReais() * quantidade;
        if(possuiItem(produto) && quantidade <= this.itens.get(this.itens.indexOf(produto)).quantidadeEmEstoque && receberPagamento(valorDaCompra, produto, quantidade) ){
            //valorDaCompra = produto.getPrecoEmReais() * quantidade;
            totalDeVendas+=valorDaCompra;

            removerProdutoEstoque(produto, quantidade); //<--- aqui tbm
            //totalItens-=produto.quantidadeEmEstoque*quantidade; //  <---  tem problema aqui
        }
        return String.format("Pagamento recebido no valor de R$ %.2f ", valorDaCompra);

    }

    public boolean receberPagamento(float valorDaCompra, Produto produto, int quantidade) {
        if (valorDaCompra == produto.getPrecoEmReais() * quantidade)
            return true;
        return false;
    }

    public float getTotalValorVendas(){
        return this.totalDeVendas;
    }

}


