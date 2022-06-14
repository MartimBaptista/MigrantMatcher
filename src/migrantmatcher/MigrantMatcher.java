package migrantmatcher;

import java.util.Scanner;

import ui.*;

public class MigrantMatcher {

	public static void main(String[] args) {
		int ajudaId = 0;
		Scanner sc = new Scanner(System.in);

		boolean terminar = false;
		while (!terminar) {
			String estado;
			System.out.print("Insira o seu estatuto: 'M' para migrante, 'A' para ajudante ('T' para terminar o programa): ");
			estado = sc.nextLine().toUpperCase();
			
			if (estado.equals("M"))
				PedeAjudaUI.iniciarPedidoDeAjuda(sc);

			else if (estado.equals("A")) {
				RegistaAjudaUI.iniciarOfertaDeAjuda(sc, ajudaId);
				ajudaId++;
				}
			else if (estado.equals("T"))
				terminar = true;
			else
				System.out.println("Valor n�o reconhecido.");
		}
		sc.close();
	}
}
