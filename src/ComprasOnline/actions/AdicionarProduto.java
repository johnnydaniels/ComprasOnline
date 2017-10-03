package ComprasOnline.actions;

import ComprasOnline.app.CarrinhoDeCompras;
import ComprasOnline.app.Estoque;
import ComprasOnline.produtos.Produto;
import ComprasOnline.view.Acao;
import ComprasOnline.view.Menu;
import ComprasOnline.view.Opcao;

public class AdicionarProduto implements Acao {

	private CarrinhoDeCompras carrinho;
	
	public AdicionarProduto(CarrinhoDeCompras carrinho) {
		this.carrinho = carrinho;
	}
	
	private class RealizaAdicao implements Acao {
		private Produto produto;
		public RealizaAdicao(Produto produto) {
			this.produto = produto;
		}
		@Override
		public void execute() {
			carrinho.addItem(produto.getSku(), produto);
		}
	}
	
	@Override
	public void execute() {		
		criaMenu().execute();
	}
	
	private Menu criaMenu() {
		Estoque estoque = Estoque.instance();
		Menu menu = new Menu("Adicionar Produtos");
		
		for (int i = 0; i < estoque.getNumberOfProducts(); i++) {
			Produto p = estoque.getProduct(i);
			Opcao op = new Opcao(p.getDescricao(), new RealizaAdicao(p));
			menu.addOpcao(op);	
		}
		
		return menu;
	}

}
