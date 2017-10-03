package ComprasOnline.app;

import ComprasOnline.produtos.Produto;

public class ItemSelecionado {
	private String id;
	private Produto produto;
	private int quantidade;
	
	public ItemSelecionado(String id, Produto produto) {
		this.id = id;
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public boolean isProduct(String id) {
		return this.id.equalsIgnoreCase(id);
	}
	
	public void add(int more) {
		quantidade += more;
	}

	public void sub(int more) {
		quantidade -= more;
	}
	
	public double getValue() {
		return quantidade * produto.getPreco();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
}
