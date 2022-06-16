package ui;

import java.util.Scanner;

import config.Configuration;
import handlers.RegistaAjudaHandler;

public class RegistaAjudaUI {

	private static final String[] REGIOES = Configuration.getInstance().getStringArray("regioes");

	public static void iniciarOfertaDeAjuda(Scanner sc) {
		RegistaAjudaHandler ajudaHandler = new RegistaAjudaHandler();
		// 1
		System.out.print("Insira o seu numero de telemovel: ");
		String numTel = sc.nextLine();
		ajudaHandler.indicaVoluntario(numTel);

		// 2
		Boolean stillSelecting = true;
		while (stillSelecting) {
			System.out.println("Insira o seu tipo de ajuda: 'A' para alojamento,'I' para item.");
			System.out.print("Ajuda do tipo: ");
			String tipoAjuda = sc.nextLine().toUpperCase();
			// 3
			if (tipoAjuda.equals("A")) {
				stillSelecting = false;
				casoAlujamento(sc, ajudaHandler);
			}
			// 4
			else if (tipoAjuda.equals("I")) {
				stillSelecting = false;
				casoItem(sc, ajudaHandler);
			} else
				System.out.println("Valor não reconhecido.");
		}

		// 5
		ajudaHandler.enviarCodigo();

		// 6
		System.out.print("Insira o código recebido para confirmar a sua oferta de ajuda: ");
		boolean confirmado = false;
		confirmado = ajudaHandler.confirmaCodigo(sc.nextLine());
		while (!confirmado) {
			System.out.print("Codigo errado, reinsira: ");
			confirmado = ajudaHandler.confirmaCodigo(sc.nextLine());
		}
		ajudaHandler.finalizarAjuda();
		System.out.println("Ajuda registada, Obrigado pela sua cooperação!");
		System.out.println("---------------------------//---------------------------");
		System.out.println("");
	}

	private static void casoAlujamento(Scanner sc, RegistaAjudaHandler ajudaHandler) {
		// 3.1
		System.out.print("Indique a quantidade de pessoas que o seu alojamento pode albergar: ");
		int room = sc.nextInt();
		ajudaHandler.indicaNumDePessoas(room);

		// 3.2
		System.out.println("Regiões:");
		for (int i = 0; i < REGIOES.length; i++) {
			System.out.println((i + 1) + ": " + REGIOES[i]);
		}

		// 3.3
		boolean stillSelecting = true;
		int index = -1;
		sc.nextLine(); // seems to fix a bug here, perhaps by clearing the input buffer, idk
		while (stillSelecting) {
			System.out.print("Insira o numero da região do seu alojamento: ");
			index = Integer.valueOf(sc.nextLine()) - 1;
			if (index >= 0 && index < REGIOES.length)
				stillSelecting = false;
			else
				System.out.println("Valor não reconhecido.");
		}
		ajudaHandler.indicaRegiao(REGIOES[index]);
	}

	private static void casoItem(Scanner sc, RegistaAjudaHandler ajudaHandler) {
		// 4.1
		System.out.print("Descreva o seu item:");
		String desc = sc.nextLine();
		ajudaHandler.descreveItem(desc);
	}

}
