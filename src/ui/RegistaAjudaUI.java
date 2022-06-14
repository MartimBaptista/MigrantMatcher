package ui;

import java.util.Scanner;

import handlers.RegistaAjudaHandler;
import sms.SMSProvider;

public class RegistaAjudaUI {
	public static void iniciarOfertaDeAjuda(Scanner sc, SMSProvider provider) {
		RegistaAjudaHandler ajudaHandler = new RegistaAjudaHandler(provider);
		// 1
		System.out.println("Insira o seu numero de telemovel:");
		String numTel = sc.nextLine();
		ajudaHandler.indicaVoluntario(numTel);

		// 2
		Boolean stillSelecting = true;
		while (stillSelecting) {
			System.out.println("Insira o seu tipo de ajuda (A: Alojamento | I: Item)");
			String tipoAjuda = sc.nextLine();
			if (tipoAjuda.equals("A")) {
				stillSelecting = false;
				// 3
				casoAlujamento(sc, ajudaHandler);
			}
			if (tipoAjuda.equals("I")) {
				stillSelecting = false;
				// 4
				casoItem(sc, ajudaHandler);
			} else {
				System.out.println("Valor n„o reconhecido.");
			}
		}
		
		// 5
		ajudaHandler.enviarCodigo();
		System.out.println("Insira o cÛdigo recebido para confirmar a sua oferta de ajuda:");
		String userInput;
		boolean confirmado = false;
		while (!confirmado) {
			userInput = sc.nextLine();
			confirmado = ajudaHandler.confirmaCodigo(userInput);
		}
		//Para ser mudado
		if (tipoAjuda.equals("Alojamento")) {
			ajudaHandler.finalizarAjudaAlojamento();
		} else {
			ajudaHandler.finalizarAjudaItem();
		}
	}

	private static void casoAlujamento(Scanner sc, RegistaAjudaHandler ajudaHandler) {
		// 1
		System.out.println("Indique a quantidade de pessoas que o seu alojamento pode albergar");
		int room = sc.nextInt();
		ajudaHandler.indicaNumDePessoas(room);

		// 2
		// TODO devolver lista de regi√µes

		// 3
		System.out.println("Escreva o nome da regi√£o do seu alojamento:");
		String regEscolhida = sc.nextLine();
		ajudaHandler.indicaRegiao(regEscolhida);

	}

	private static void casoItem(Scanner sc, RegistaAjudaHandler ajudaHandler) {
		// 1
		System.out.println("Descreva o seu item:");
		String desc = sc.nextLine();
		ajudaHandler.descreveItem(desc);
	}

}
