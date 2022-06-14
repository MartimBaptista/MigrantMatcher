package handlers;

import java.util.Random;

import ajudas.Ajuda;
import builders.AjudaBuilder;
import catalogs.AjudaCatalog;
import catalogs.VoluntarioCatalog;
import config.Configuration;
import sms.PidgeonSMSAdapter;
import sms.SMSProvider;
import users.Voluntario;

public class RegistaAjudaHandler {
	private Voluntario voluntario;
	private VoluntarioCatalog voluntarioCatalog;
	private AjudaBuilder ab;
	private AjudaCatalog ajudaCatalog;
	private String sentCode;
	private int ajudaId;
	
	private static SMSProvider provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());

	public RegistaAjudaHandler(int ajudaCounter) {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		ab = new AjudaBuilder();
		this.ajudaId = ajudaCounter;
	}

	public void indicaVoluntario(String tele) {
		voluntario = new Voluntario(tele);
	}

	public void indicaNumDePessoas(int num) {
		ab.setCapacidade(num);
	}

	public void indicaRegiao(String reg) {
		ab.setRegiao(reg);
	}

	public void descreveItem(String desc) {
		ab.setDescription(desc);
	}

	public void enviarCodigo() {
		sentCode = String.valueOf(new Random().nextInt(0, 100000));
		String message = "O seu c�digo �: " + sentCode;
		provider.sendSMS(voluntario.getTele(), message);
	}

	public boolean confirmaCodigo(String recievedCode) {
		if (recievedCode.equals(sentCode))
			return true;
		else
			return false;
	}

	public void finalizarAjuda() {
		ab.setId(ajudaId);
		Ajuda ajuda = ab.getAjuda();
		ajudaCatalog.put(String.valueOf(ajudaId), ajuda);
		voluntarioCatalog.put(voluntario.getTele(), voluntario);
	}
}
