package ComprasOnline.view;
import java.util.Scanner;

public class Console {

	private static Scanner teclado = new Scanner(System.in);

	public static void println(Object mensagem) {
		System.out.println(mensagem.toString());
	}

	public static void print(Object mensagem) {
		System.out.print(mensagem.toString());
	}

	public static String readString() {
		return teclado.nextLine();
	}
	
	public static String readString(String prompt) {
		print(prompt);
		return readString();
	}
	
	public static int readInt() {
		return teclado.nextInt();
	}
	
	public static int readInt(String prompt) {
		print(prompt);
		return readInt();
	}
	
}
