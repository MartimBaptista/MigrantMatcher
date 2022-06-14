package handlers;

import java.util.Random;

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
		this.voluntarioCatalog = VoluntarioCatalog.getInstance();
		this.ajudaCatalog = AjudaCatalog.getInstance();
		this.ab = new AjudaBuilder();
		this.ajudaId = ajudaCounter;
	}

	public void indicaVoluntario(String tele) {
		this.voluntario = new Voluntario(tele);
	}

	public void indicaNumDePessoas(int num) {
		this.ab.setCapacidade(num);
	}

	public void indicaRegiao(String reg) {
		this.ab.setRegiao(reg);
	}

	public void descreveItem(String desc) {
		this.ab.setDescription(desc);
	}

	public void enviarCodigo() {
		this.sentCode = String.valueOf(new Random().nextInt(0, 100000));
		String message = "O seu código é: " + sentCode;
		provider.sendSMS(voluntario.getTele(), message);
	}

	public boolean confirmaCodigo(String recievedCode) {
		if (recievedCode.equals(sentCode))
			return true;
		else
			return false;
	}

	public void finalizarAjuda() {
		this.ab.setId(ajudaId);
		this.ajudaCatalog.put(String.valueOf(ajudaId), ab.getAjuda());
		this.voluntarioCatalog.put(voluntario.getTele(), voluntario);
	}
}
