package ComprasOnline.view;

public class Menu {

	private static final int MAX_OPCOES = 10;
	
	private Opcao[] opcoes = new Opcao[MAX_OPCOES];
	private int numOpcoes = 0;

	private String titulo;

	
	public Menu(String titulo) {
		this.titulo = titulo;
	}

	public void addOpcao(Opcao opcao) {
		if (numOpcoes < MAX_OPCOES) {
			opcoes[numOpcoes] = opcao;
			numOpcoes++;
			opcao.setAtalho(numOpcoes);
		}
	}

	public void execute() {
		exibir();
		executaAcao(Console.readInt("Opcao: "));		
	}
	
	private void exibir() {
		Console.println("--- " + titulo + " ---");
		for (int i = 0; i < numOpcoes; i++) {
			Console.println(opcoes[i].getDisplayFormat());
		}
	}

	private void executaAcao(int atalho) {
		for (int i = 0; i < numOpcoes; i++) {
			if (opcoes[i].executaIf(atalho))
				return;
		}
		Console.println("Opcao invalida!");
	}
	
}
