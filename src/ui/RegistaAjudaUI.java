package ui;

import java.util.Scanner;

import handlers.RegistaAjudaHandler;
import sms.SMSProvider;

public class RegistaAjudaUI {
	
	private static final String[] REGIOES = { "Alentejo Central", "Alentejo Litoral", "Alto Alentejo", "Baixo Alentejo",
			"Leziria do Tejo", "Algarve", "Beira Baixa", "Beiras e Serra da Estrela", "Medio Tejo", "Aveiro", "Coimbra",
			"Leiria", "Viseu", "Lisboa", "Alto Minho", "Alto Tamega", "Porto", "Ave", "Cavado", "Douro",
			"Tamega e Sousa", "Tras-os-Montes" };
	
	public static void iniciarOfertaDeAjuda(Scanner sc, SMSProvider provider, int ajudaId) {
		RegistaAjudaHandler ajudaHandler = new RegistaAjudaHandler(provider, ajudaId);
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
			} 
			else
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
		//TODO Catch incorrect input
		

		// 3.2
		System.out.println("Regiões:");
		for (int i = 0; i < REGIOES.length; i++) {
			System.out.println((i + 1) + ": " + REGIOES[i]);
		}

		// 3.3
		System.out.println("Insira o numero da região do seu alojamento:");
		boolean stillSelecting = true;
		int index = -1;
		sc.nextLine();
		while (stillSelecting) {
			index = Integer.valueOf(sc.nextLine()) - 1;
			if(index >= 0 && index < REGIOES.length)
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
