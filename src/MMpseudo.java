import java.util.Scanner;

import config.Configuration;
import handlers.PedeAjudaHandler;
import handlers.RegistaAjudaHandler;
import sms.*;

public class MMpseudo {
	
	private static final String[] regioes = {"Alentejo Central", "Alentejo Litoral", "Alto Alentejo", "Baixo Alentejo",
			"Leziria do Tejo", "Algarve", "Beira Baixa", "Beiras e Serra da Estrela", "Medio Tejo", "Aveiro", "Coimbra",
			"Leiria", "Viseu", "Lisboa", "Alto Minho", "Alto Tamega", "Porto", "Ave", "Cavado", "Douro",
			"Tamega e Sousa", "Tras-os-Montes"};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());
		String estado;
		Boolean running = true;
		while (running) {
			System.out.println("Insira o seu estatuto: 'M' para migrante 'A' para ajudante");
			estado = sc.nextLine();
			if (estado.equals("M")) {
				iniciarPedidoDeAjuda(sc);
				running = false;
				sc.close();
				
			}
			else if (estado.equals("A")) {
				iniciarOfertaDeAjuda(sc, provider);
				running = false;
				sc.close();
			}
			else {
				System.out.println("Valor n�o reconhecido.");
			}
		}
	}

	private static void iniciarOfertaDeAjuda(Scanner sc, SMSProvider provider) {
		RegistaAjudaHandler ajudaHandler = new RegistaAjudaHandler(provider);
		System.out.println("Insira o seu numero de telemovel:");  
		String numTel = sc.nextLine();
		ajudaHandler.indicaVoluntario(numTel);
		System.out.println("Insira o seu tipo de ajuda:");
		String tipoAjuda = sc.nextLine();
		if (tipoAjuda.equals("Alojamento")) {
			System.out.println("Indique a quantidade de pessoas que o seu alojamento pode albergar");
			int room = sc.nextInt();
			ajudaHandler.indicaNumDePessoas(room);
			
			// TODO devolver lista de regiões
			
			System.out.println("Escreva o nome da região do seu alojamento:");
			String regEscolhida = sc.nextLine();
			ajudaHandler.indicaRegiao(regEscolhida);
		}
		else  {
			System.out.println("Descreva o seu item:");
			String desc = sc.nextLine();
			ajudaHandler.descreveItem(desc);	
		}
		ajudaHandler.enviarCodigo();
		System.out.println("Insira o código recebido para confirmar a sua oferta de ajuda:");
		boolean confirmado = false;
		String userInput;
		while (!confirmado) {
			userInput = sc.nextLine();
			confirmado = ajudaHandler.confirmaCodigo(userInput);
		}
		if (tipoAjuda.equals("Alojamento")) {
			ajudaHandler.finalizarAjudaAlojamento();
		}
		else {
			ajudaHandler.finalizarAjudaItem();
		}
	}

	private static void iniciarPedidoDeAjuda(Scanner sc) {
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
	


