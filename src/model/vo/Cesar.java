package model.vo;

import javax.swing.JOptionPane;

public class Cesar {

	private String mensagem;
	private int chave;

	public static char[] alfabeto = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z' };

	public Cesar() {
		super();
	}

	public Cesar(String mensagem, int chave) {
		super();
		this.mensagem = mensagem;
		this.chave = chave;

	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public static char[] getAlfabeto() {
		return alfabeto;
	}

	public static void setAlfabeto(char[] alfabeto) {
		Cesar.alfabeto = alfabeto;
	}

	public void lerDados() {

		String msg = JOptionPane.showInputDialog("Digite uma mensagem");

		setMensagem(msg.toUpperCase());

		int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite a chave"));

		setChave(chave);

	}

	public char[] criptografar() {
		char[] novaMensagem = new char[getMensagem().length()];

		for (int i = 0; i < getMensagem().length(); i++) {
			if (getMensagem().charAt(i) == ' ') {
				novaMensagem[i] = getMensagem().charAt(i);
			} else {
				for (int j = 0; j < getAlfabeto().length; j++) {
					if (getMensagem().charAt(i) == getAlfabeto()[j]) {
						if (getChave() < 0) {
							novaMensagem[i] = getAlfabeto()[(j + getChave() + getAlfabeto().length)
									% getAlfabeto().length];
							j = getAlfabeto().length;
						} else {
							novaMensagem[i] = getAlfabeto()[(j + getChave()) % getAlfabeto().length];
							j = getAlfabeto().length;
						}

					} else {
						novaMensagem[i] = getMensagem().charAt(i);

					}
				}

			}
		}
		System.out.println(novaMensagem);
		return novaMensagem;
	}

	public char[] decifrar() {
		char[] novaMensagem = new char[getMensagem().length()];

		for (int i = 0; i < getMensagem().length(); i++) {
			if (getMensagem().charAt(i) == ' ') {
				novaMensagem[i] = getMensagem().charAt(i);
			} else {
				for (int j = 0; j < getAlfabeto().length; j++) {
					if (getMensagem().charAt(i) == getAlfabeto()[j]) {
						if (j < getChave()) {
							novaMensagem[i] = getAlfabeto()[(j - getChave() + getAlfabeto().length)
									% getAlfabeto().length];
							j = getAlfabeto().length;
						} else {
							novaMensagem[i] = getAlfabeto()[(j - getChave()) % getAlfabeto().length];
							j = getAlfabeto().length;
						}

					} else {
						novaMensagem[i] = getMensagem().charAt(i);

					}
				}

			}
		}
		return novaMensagem;

	}
}
