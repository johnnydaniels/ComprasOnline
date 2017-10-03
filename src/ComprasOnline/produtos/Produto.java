package ComprasOnline.produtos;

abstract public class Produto {

	private String sku;
	private double preco;
	
	@Override
	public String toString() {
		return getDescricao();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o instanceof Produto) {
			return ((Produto)o).sku.equalsIgnoreCase(sku);
		}
		return false;
	}
	
	public Produto(String sku, double preco) {
		this.sku = sku;
		this.preco = preco;
	}
	
	public String getSku() {
		return sku;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	abstract public String getDescricao();
}
