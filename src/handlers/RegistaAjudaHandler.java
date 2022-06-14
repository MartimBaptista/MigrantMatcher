package handlers;

import java.util.Random;

import ajudas.Ajuda;
import builders.AjudaBuilder;
import catalogs.AjudaCatalog;
import catalogs.VoluntarioCatalog;
import sms.SMSProvider;
import users.Voluntario;

public class RegistaAjudaHandler {
	private Voluntario voluntario;
	private VoluntarioCatalog voluntarioCatalog;
	private AjudaBuilder ab;
	private AjudaCatalog ajudaCatalog;
	private SMSProvider smsProvider;
	private String sentCode;
	private int ajudaId;

	public RegistaAjudaHandler(SMSProvider smsProvider, int ajudaCounter) {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		ab = new AjudaBuilder();
		this.smsProvider = smsProvider;
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
		String message = "O seu código é: " + sentCode;
		smsProvider.sendSMS(voluntario.getTele(), message);
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
