package ui;

import java.util.Scanner;

import ajudas.Ajuda;
import config.Configuration;
import handlers.PedeAjudaHandler;

public class PedeAjudaUI {

	private static final String[] REGIOES = Configuration.getInstance().getStringArray("regioes");

	public static void iniciarPedidoDeAjuda(Scanner sc) {
		PedeAjudaHandler pedeAjudaHandler = new PedeAjudaHandler();
		// 1
		System.out.println("Insira como se pretende registar: 'I' individual,'F' familia.");
		System.out.print("Registo do tipo:");
		String registoTipo = sc.nextLine().toUpperCase();
		// 1.1
		if (registoTipo.equals("I")) {
			System.out.print("Indique o seu nome: ");
			pedeAjudaHandler.indicaNomeMigrante(sc.nextLine());
			System.out.print("Indique o seu numero de telefone: ");
			pedeAjudaHandler.indicaTeleMigrante(sc.nextLine());
		}
		// 1.2
		else if (registoTipo.equals("F")) {
			System.out.print("Indique a quantidade de pessoas que existem na familia: ");
			boolean valid = false;
			int numPessoas = 0;
			while (!valid) {
				numPessoas = sc.nextInt();
				if (numPessoas > 0)
					valid = true;
				else
					System.out.print("Valor nao reconhecido. Reinsira: ");
			}
			pedeAjudaHandler.indicaNumFamiliar(numPessoas);
			// 1.2.(1,2)
			System.out.print("Insira o nome do cabeca de familia: ");
			pedeAjudaHandler.indicaNomeMigrante(sc.nextLine()); // Bug here
			System.out.print("Insira o numero de telefone do cabeca de familia: ");
			pedeAjudaHandler.indicaTeleMigrante(sc.nextLine());
			// 1.2.(3,4,5)
			System.out.println("Indique agora os nomes de outros familiares.");
			for (int i = 0; i < numPessoas; i++) {
				System.out.println("Indique o nome do " + (i + 1) + " familiar: ");
				pedeAjudaHandler.indicaFamiliar(sc.nextLine());
			}
		}
		pedeAjudaHandler.registarMigrante();

		// 2,3,4
		System.out.println("Regioes:");
		for (int i = 0; i < REGIOES.length; i++) {
			System.out.println((i + 1) + ": " + REGIOES[i]);
		}
		boolean stillSelecting = true;
		int index = -1;
		while (stillSelecting) {
			System.out.print("Insira o numero da regiao para onde se quer mover: ");
			index = Integer.valueOf(sc.nextLine()) - 1;
			if (index >= 0 && index < REGIOES.length)
				stillSelecting = false;
			else
				System.out.println("Valor nao reconhecido.");
		}
		pedeAjudaHandler.registaRegiao(REGIOES[index]);

		// 5
		boolean repeat = true;
		while (repeat) {
			Ajuda[] ajudas = pedeAjudaHandler.ajudasDisponiveis();
			if (ajudas.length > 0) {
				for (int i = 0; i < ajudas.length; i++) {
					System.out.println((i + 1) + ": " + ajudas[i]);
				}
				stillSelecting = true;
				index = -1;
				while (stillSelecting) {
					// 6
					System.out.print("Insira o numero da ajuda que pretende obter: ");
					index = Integer.valueOf(sc.nextLine()) - 1;
					if (index >= 0 && index < ajudas.length)
						stillSelecting = false;
					else
						System.out.println("Valor nao reconhecido.");
				}
				// 7,10
				pedeAjudaHandler.indicaAjuda(ajudas[index]);

				// 8,9
				System.out.print("Obter mais ajudas? ('S' Sim, 'N' Nao): ");
				if (sc.nextLine().toUpperCase() == "N")
					repeat = false;
			}
			// 5a
			else {
				// 5a.5
				System.out.println("Nao existe nenhuma ajuda nesta regiao :(");
				System.out.print("Deseja ser notificado quando houver? ('S' Sim, 'N' Nao): ");
				if (sc.nextLine().toUpperCase() == "S")
					pedeAjudaHandler.ativarNotificacao();
				repeat = false;
			}
		}
		System.out.println("Obrigado pela sua cooperação!");
		System.out.println("---------------------------//---------------------------");
		System.out.println("");
	}
}
