package notificacoes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import users.Migrante;


public class Notificador {
	private static Notificador instance;
	private Map<String, Collection<Migrante>> subscribers;

	private Notificador() {
		subscribers = new HashMap<>();
		
	}

	public static Notificador getInstance() {
		if (instance == null)
			instance = new Notificador();
		return instance;
	}
	
	
	public void subscribe(Migrante migrante, String regiao) {
		
	}
	
	public void unsubscribe(Migrante migrante, String regiao) {
		
	}
	
	public void notificar(String regiao) {
		
	}
}
