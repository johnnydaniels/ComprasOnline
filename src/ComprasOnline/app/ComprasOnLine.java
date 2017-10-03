package ComprasOnline.app;

import ComprasOnline.actions.AdicionarProduto;
import ComprasOnline.view.Acao;
import ComprasOnline.view.Console;
import ComprasOnline.view.Menu;
import ComprasOnline.view.Opcao;

public class ComprasOnLine {

	private static CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

	private static boolean executaSistema = true;
	
	public static void main(String[] args) {
		// Inicializacao das variaveis do sistema.
		Menu menuPrincipal = criaMenuPrincipal();
		Estoque.instance().setNotifier(carrinho);
		
		
		// Executa menu principal
		while (executaSistema) {
			menuPrincipal.execute();
		}
		// Mostra resultado da compra.
		Console.println(carrinho.listItems());
		Console.println("Total da compra: " + carrinho.getTotal());
	}

	private static Menu criaMenuPrincipal() {
		Menu menu = new Menu("Menu Principal");
		
		Acao acao = null;
		
		menu.addOpcao( new Opcao("Adicionar Produto",
				                 new AdicionarProduto(carrinho)) );
		menu.addOpcao( new Opcao("Remover Produto",acao) );
		menu.addOpcao( new Opcao("Listar Produtos",acao) );
		menu.addOpcao( new Opcao("Mostrar Carrinho",acao) );

		menu.addOpcao( new Opcao("Sair", new Acao() {
			@Override
			public void execute() {
				executaSistema = false;
			}
		}) );
		
		return menu;
	}
}
