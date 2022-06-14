package MigrantMatcher;
import java.util.Scanner;

import config.Configuration;
import handlers.PedeAjudaHandler;
import sms.*;
import ui.*;

public class MigrantMatcher {
	
	private static final String[] regioes = {"Alentejo Central", "Alentejo Litoral", "Alto Alentejo", "Baixo Alentejo",
			"Leziria do Tejo", "Algarve", "Beira Baixa", "Beiras e Serra da Estrela", "Medio Tejo", "Aveiro", "Coimbra",
			"Leiria", "Viseu", "Lisboa", "Alto Minho", "Alto Tamega", "Porto", "Ave", "Cavado", "Douro",
			"Tamega e Sousa", "Tras-os-Montes"};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());
		String estado;
		Boolean stillSelecting = true;
		while (stillSelecting) {
			System.out.println("Insira o seu estatuto: 'M' para migrante 'A' para ajudante");
			estado = sc.nextLine();
			if (estado.equals("M")) {
				PedeAjudaUI.iniciarPedidoDeAjuda(sc);
				stillSelecting = false;
				sc.close();
				
			}
			else if (estado.equals("A")) {
				RegistaAjudaUI.iniciarOfertaDeAjuda(sc, provider);
				stillSelecting = false;
				sc.close();
			}
			else {
				System.out.println("Valor não reconhecido.");
			}
		}
	}

	

	
		
}
	


