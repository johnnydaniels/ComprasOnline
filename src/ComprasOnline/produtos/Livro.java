package ComprasOnline.produtos;

public class Livro extends Produto {
	private String titulo;
	private String editora;
	
	public Livro(String titulo, String sku, double preco) {
		super(sku,preco);
		this.titulo = titulo;
		this.editora = "";
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String getDescricao() {
		if (editora == null || editora.isEmpty()) {
			return String.format("Livro: %s (R$ %.02f)",
						         titulo,getPreco());
		} 
		return String.format("Livro: %s/%s (R$ %.02f)",
	                         titulo,editora,getPreco());
	}
}
