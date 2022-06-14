package MigrantMatcher;

import java.util.Scanner;

import config.Configuration;
import sms.*;
import ui.*;

public class MigrantMatcher {

	public static void main(String[] args) {
		int ajudaId = 0;
		Scanner sc = new Scanner(System.in);
		SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());

		boolean terminar = false;
		while (!terminar) {
			String estado;
			System.out.print("Insira o seu estatuto: 'M' para migrante, 'A' para ajudante ('T' para terminar o programa): ");
			estado = sc.nextLine().toUpperCase();
			
			if (estado.equals("M"))
				PedeAjudaUI.iniciarPedidoDeAjuda(sc);

			else if (estado.equals("A")) {
				RegistaAjudaUI.iniciarOfertaDeAjuda(sc, provider, ajudaId);
				ajudaId++;
				}
			else if (estado.equals("T"))
				terminar = true;

			else
				System.out.println("Valor não reconhecido.");
		}
		sc.close();
	}
}
