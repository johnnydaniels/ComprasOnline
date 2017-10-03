package ComprasOnline.view;

public class Opcao {
	private String label;
	private int atalho;
	private Acao acao;
	
	public Opcao(String label, Acao acao) {
		this.label = label;
		this.acao = acao;
	}

	public void setAtalho(int atalho) {
		this.atalho = atalho;
	}
	
	public String getDisplayFormat() {
		return String.format("[%d] %s", atalho, label);
	}

	public boolean executaIf(int atalho) {
		if (this.atalho == atalho) {
			acao.execute();
			return true;
		}
		return false;
	}
}
