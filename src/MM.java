import java.util.Scanner;

public class MM {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String estado;
		boolean running = true;
		while (running) {
			System.out.println("Insira o seu estatuto: 'M' para migrante 'A' para ajudante");
			estado = sc.nextLine();
			if (estado.equals("M")) {
				iniciarPedidoDeAjuda(sc);
				running = false;
				sc.close();

			} else if (estado.equals("A")) {
				iniciarOfertaDeAjuda(sc);
				running = false;
				sc.close();
			} else {
				// erro
			}
		}
	}

	private static void iniciarOfertaDeAjuda(Scanner sc) {
		System.out.println("Insira o seu numero de telemovel:");
		int numTel = sc.nextInt();
		// criar voluntario inicializado com numero de telemovel -
		// indentificarVoluntario(tele) ???
		System.out.println("Insira o seu tipo de ajuda:");
		String tipoAjuda = sc.nextLine();
		if (tipoAjuda.equals("Alojamento")) {
			// iniciar ajuda do tipo de alojamento
			// onde se indica o numero de pessoas possiveis de alojar
			// provavelmente noutra class

			// o sistema devolve lista regi�es
			// o voluntario diz qual a regi�o
			// .contains("regiao")

			// criar Ajuda do tipo Alojamento com regi�o e num de pessoas indicados
		} else {
			System.out.println("Descreva o seu item:");
			String desc = sc.nextLine();
			// Criar ajuda do tipo Item com descri��o = desc;

		}
		// SMS SHIT YIKES!

	}

	private static void iniciarPedidoDeAjuda(Scanner sc) {
		System.out.println("Pretende registar-se individualmente ou com familia?");
		String registoTipo = sc.nextLine();
		if (registoTipo.equals("individualmente")) {
			// indentificarMigrante()
		} else if (registoTipo.equals("familia")) {
			// perguntar e receber o cabe�a

			System.out.println("Indique agora os dados de outros familiares");
			System.out.println("Quando n�o tiver mais membros a adicionar escreva 'stop'");
			boolean running = true;
			while (running) {
				System.out.println("Indique o nome:");
				String nomeAgora = sc.nextLine();
				if (nomeAgora.equals("stop")) {
					running = false;
				}
				System.out.println("Indique o numero de telemovel:");
				int contacto = sc.nextInt();
				// push this member to wherever we are pushing
			}
			// push them all together

			// give regioes
			// Migrant chooses regiao

			// extens�o 5a: A regiao n�o tem ajudas
			// extens�o 6: Perguntamos ao Migrante se quer se notificado quando houver
			// 5) devolver Ajudas (alojamento e outros) dessa regiao (ORDENAR POR DATA DE
			// DISPONIBILIZA��O CRESCENTE ou
			// Outra forma ser� primeiro por alojamentos, depois pelos outros items,
			// ordenados dentro de cada categoria de forma aleat�ria.

			// loop
			// 6) migrant chooses Ajuda das disponiveis

			// migrant confirma

			// atribuir a(s) Ajuda(s) ao Migrant
			// contactar voluntario por SMS
		}

	}
}
