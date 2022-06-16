package notificacoes;

import java.util.HashMap;
import java.util.Map;

import config.Configuration;
import sms.PidgeonSMSAdapter;
import sms.SMSProvider;
import users.Voluntario;

public class NotificadorVoluntario implements Notificador<Voluntario, Integer> {
	private static NotificadorVoluntario instance = new NotificadorVoluntario();
	private Map<Integer, Voluntario> subscribers;
	private SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());
	

	private NotificadorVoluntario() {
		subscribers = new HashMap<>();
	}

	public static NotificadorVoluntario getInstance() {
		return instance;
	}
	
	@Override
	public void subscribe(Voluntario voluntario, Integer ajudaID) {
		subscribers.put(ajudaID, voluntario);
	}

	@Override
	public void unsubscribe(Voluntario voluntario, Integer ajudaID) {
		subscribers.remove(ajudaID, voluntario);
	}

	@Override
	public void unsubscribeALL(Voluntario voluntario) {
		for (Map.Entry<Integer,Voluntario> entry : subscribers.entrySet()) {
			if(entry.getValue().equals(voluntario))
				subscribers.remove(entry.getKey(), voluntario);
		}
	}
	
	@Override
	public void notificar(Integer ajudaID) {
		provider.sendSMS(subscribers.get(ajudaID).getTele(), "A ajuda com o id: " + ajudaID + " foi requesitada por um migrante.");
	}
}
