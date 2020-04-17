package model.vo;

import javax.swing.JOptionPane;

public class MainCesar {

	public static void main(String[] args) {
		Cesar c = new Cesar();

		int opcao = 1;
		while (opcao != 0) {

			opcao = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha 1 para criptografar, 2 para decriptografar, ou 0 para sair"));

			if (opcao == 1) {
				c.lerDados();
				String resultadoCifra = new String(c.criptografar());
				JOptionPane.showInputDialog("Copie a mensagem (CIFRA):", resultadoCifra);
			} else if (opcao == 2) {
				c.lerDados();
				String resultadoDecifra = new String(c.decifrar());
				JOptionPane.showInputDialog("Copie a mensagem (DECIFRA):", resultadoDecifra);
			}
		}

	}
}
