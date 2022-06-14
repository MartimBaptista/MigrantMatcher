package ui;

import java.util.Scanner;

import handlers.PedeAjudaHandler;

public class PedeAjudaUI {
	public static void iniciarPedidoDeAjuda(Scanner sc) {
		PedeAjudaHandler pedeAjudaHandler = new PedeAjudaHandler();
		System.out.println("Pretende registar-se individualmente ou com familia?");
		String registoTipo = sc.nextLine();
		if (registoTipo.equals("individualmente")) {
			System.out.println("Indique o seu nome:");
			String nome = sc.nextLine();
			System.out.println("Indique o seu numero de telefone:");
			String numTel = sc.nextLine();
			pedeAjudaHandler.indicaMigrante(nome, numTel);
		}
		else if (registoTipo.equals("familia")) {
			System.out.println("Indique a quantidade de pessoas que existem na familia:");
			int numPessoas = sc.nextInt();
			pedeAjudaHandler.indicaNumFamilia(numPessoas);
			System.out.println("Insira o nome do cabeça de familia:");
			String nome = sc.nextLine();
			System.out.println("Indique o seu numero de telefone:");
			String numTel = sc.nextLine();
			pedeAjudaHandler.indicaMigrante(nome, numTel);
			
			System.out.println("Indique agora os nomes de outros familiares");
			for (int i = 0; i < numPessoas; i++) {
				System.out.println("Indique o nome do "+(i+1)+" familiar:");
				String nomeAgora = sc.nextLine();
				pedeAjudaHandler.indicaFamiliar(nomeAgora);
			}
		}
		
		//TODO mostrar lista de regioes
		
		System.out.println("Indique uma regiao para onde se podera mover:");
		String regiao = sc.nextLine();
		pedeAjudaHandler.indicaRegiao(regiao);
		
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
