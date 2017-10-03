package ComprasOnline.app;

import ComprasOnline.app.interfaces.Publisher;
import ComprasOnline.app.interfaces.Subscriber;
import ComprasOnline.produtos.Camiseta;
import ComprasOnline.produtos.Livro;
import ComprasOnline.produtos.Produto;
import ComprasOnline.view.Console;

public final class Estoque implements Subscriber {
	private final int MAX_PRODUCTS = 10;

	private Produto[] produtos = new Produto[MAX_PRODUCTS];
	private int numberOfProdutcs = 0;
	
	private static Estoque singleInstance;
	public static Estoque instance() {
		if (singleInstance == null) {
			singleInstance = new Estoque();

			singleInstance.addProduct(
						new Livro("Senhor dos Anéis", "senhor", 120.00)
					);
			singleInstance.addProduct(
						new Livro("Algorithms", "algorithms", 427.00)
					);
			singleInstance.addProduct(
						new Livro("O Pequeno Príncipe","principe",10.00)
					);
			singleInstance.addProduct(
						new Camiseta("Azul", 5, "azul", 10.00)
					);
			singleInstance.addProduct(
						new Camiseta("Vermelha", 4, "vermelha", 15.00)
					);
			singleInstance.addProduct(
					new Camiseta("Preta", 8, "preta", 12.00)
				);
			singleInstance.addProduct(
					new Livro("O Alquimista", "alquimista", 55.00)
				);

		}
		return singleInstance;
	}
	
	private Estoque() {}

	public void setNotifier(Publisher publisher) {
		publisher.subscribe(this);
	}

	private void addProduct(Produto produto) {
		if (numberOfProdutcs < MAX_PRODUCTS ) {
			produtos[numberOfProdutcs] = produto;
			numberOfProdutcs++;
		}
	}
	
	public Produto search(String key) {
		for (Produto p : produtos) {
			if (p != null) {
				if (p.getSku().equalsIgnoreCase(key))
					return p;
			}
		}
		return null;
	}

	public int getNumberOfProducts() {
		return numberOfProdutcs ;
	}

	public Produto getProduct(int i) {
		if (i < numberOfProdutcs) {
			return produtos[i];
		}
		return null;
	}

	@Override
	public void eventOcurred(Object sender) {
		for (int i = 0; i < numberOfProdutcs; i++) {
			if (produtos[i].equals(sender)) {
				Console.println("Vendido: " + produtos[i].getSku());
				return;
			}
		}
	}
}
