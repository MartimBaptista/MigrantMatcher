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
	private int idConter;

	public RegistaAjudaHandler(SMSProvider smsProvider) {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		ab = new AjudaBuilder();
		this.smsProvider = smsProvider;
		idConter = 0;
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
		System.out.println("[System: Sent message: \"" + message + "\" ]");
	}

	public boolean confirmaCodigo(String recievedCode) {
		if (recievedCode.equals(sentCode))
			return true;
		else
			return false;
	}

	public void finalizarAjudaAlojamento() {
		Ajuda ajuda = ab.getAlojamento();
		finalizarAjuda(ajuda);
	}

	public void finalizarAjudaItem() {
		Ajuda ajuda = ab.getItem();
		finalizarAjuda(ajuda);
	}

	void finalizarAjuda(Ajuda ajuda) {
		ajudaCatalog.set(String.valueOf(idConter), ajuda);
		idConter++;
		voluntarioCatalog.set(voluntario.getTele(), voluntario);
	}
}
