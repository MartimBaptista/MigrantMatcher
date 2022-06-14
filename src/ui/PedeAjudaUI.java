package ui;

import java.util.Scanner;

import handlers.PedeAjudaHandler;
import sorters.Sorter;

public class PedeAjudaUI {
	public static void iniciarPedidoDeAjuda(Scanner sc, Sorter sorter) {
		PedeAjudaHandler pedeAjudaHandler = new PedeAjudaHandler(sorter);
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
				if(numPessoas > 0)
					valid = true;
				else
					System.out.print("Valor n�o reconhecido. Reinsira: ");
			}
			pedeAjudaHandler.indicaNumFamilia(numPessoas);
			// 1.2.(1,2)
			System.out.print("Insira o nome do cabe�a de familia: ");
			pedeAjudaHandler.indicaNomeMigrante(sc.nextLine());
			System.out.print("Insira o numero de telefone do cabe�a de familia: ");
			pedeAjudaHandler.indicaTeleMigrante(sc.nextLine());
			// 1.2.(3,4,5)
			System.out.println("Indique agora os nomes de outros familiares.");
			for (int i = 0; i < numPessoas; i++) {
				System.out.println("Indique o nome do " + (i + 1) + " familiar: ");
				pedeAjudaHandler.indicaFamiliar(sc.nextLine());
			}
		}
		
		// 2
		//TODO mostrar lista de regioes
		
		System.out.println("Indique uma regiao para onde se podera mover:");
		String regiao = sc.nextLine();
		
		//TODO devolver as ajudas nesta regiao
		//5)  devolver Ajudas (alojamento e outros) dessa regiao   (ORDENAR POR DATA DE DISPONIBILIZAÇÃO CRESCENTE ou
        // Outra forma será primeiro por alojamentos, depois pelos outros items, ordenados dentro de cada categoria de forma aleatória.
		
		//TODO extensão 5a: A regiao não tem ajudas
		/*
		  TODO OOPS, esta regiao não tem ajudas!
		  System.out.println("A regiao escolhida nao tem nenhuma ajuda disponivel neste momento.");
		  //extensão 6:
		  System.out.println("Pretende ser notificado por sms quando existir? (y/n)");
		  String resposta = sc.nextLine();
		  if (resposta.equals("y")) {
		  	then do extra SMS stuff TODO
		  }
		 */
		
		//TODO devolver lista de ajudas
		
		System.out.println("Escolha que ajuda(s) pretende usufruir, escreva 'stop' quando bastar");
		String sinal = "OK";
		while (!sinal.equals("stop")) {
			sinal = sc.nextLine();
			
			//TODO escolher ajudas
		}
		
		//TODO confirm
		//TODO atribuir ajuda e contactar voluntarios
	}
}
