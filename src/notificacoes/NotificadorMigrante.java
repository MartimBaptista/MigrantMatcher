package notificacoes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import config.Configuration;
import sms.PidgeonSMSAdapter;
import sms.SMSProvider;
import users.Migrante;


public class NotificadorMigrante implements Notificador<Migrante,String>{
	private static NotificadorMigrante instance = new NotificadorMigrante();
	private Map<String, Collection<Migrante>> subscribers;
	private SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());
	

	private NotificadorMigrante() {
		subscribers = new HashMap<>();
		String[] regioes = Configuration.getInstance().getStringArray("regioes");
		for (String string : regioes) {
			subscribers.put(string, new ArrayList<Migrante>());
		}
	}

	public static NotificadorMigrante getInstance() {
		return instance;
	}
	
	@Override
	public void subscribe(Migrante migrante, String regiao) {
		subscribers.get(regiao).add(migrante);
	}
	
	@Override
	public void unsubscribe(Migrante migrante, String regiao) {
		subscribers.get(regiao).remove(migrante);
	}
	
	@Override
	public void unsubscribeALL(Migrante migrante) {
		for (Collection<Migrante> group : subscribers.values()) {
			group.remove(migrante);
		}
	}
	
	@Override
	public void notificar(String regiao) {
		ArrayList<Migrante> toNotify = (ArrayList<Migrante>) subscribers.get(regiao);
		for (Migrante migrante : toNotify) {
			provider.sendSMS(migrante.getTele(), ("A região " + regiao + " tem alojamentos disponiveis."));
		}
	}
}
