package ComprasOnline.produtos;

public class Camiseta extends Produto {
	private int tamanho;
	private String cor;
	
	public Camiseta(String cor, int tamanho, String sku, double preco)
	{
		super(sku, preco);
		this.cor = cor;
		this.tamanho = tamanho;
	}

	@Override
	public String getDescricao() {
		return String.format("Camiseta %s tamanho %d (R$ %.02f)",
							 cor, tamanho, getPreco());
	}
	
}
