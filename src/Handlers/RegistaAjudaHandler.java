package Handlers;

import java.util.Random;

import Ajudas.Ajuda;
import Builders.AjudaBuilder;
import Catalogs.AjudaCatalog;
import Catalogs.VoluntarioCatalog;
import SMS.SMSSender;
import Users.Voluntario;

public class RegistaAjudaHandler {
	private static RegistaAjudaHandler instance;
	private VoluntarioCatalog voluntarioCatalog;
	private AjudaCatalog ajudaCatalog;
	private Voluntario voluntario;
	private AjudaBuilder ab;
	private String sentCode;
	private int idConter;

	private RegistaAjudaHandler() {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		ab = new AjudaBuilder();
		idConter = 0;
	}

	public static RegistaAjudaHandler getInstance() {
		if (instance == null) {
			return new RegistaAjudaHandler();
		} else {
			return instance;
		}
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
		SMSSender.sendSMS(voluntario.getTele(), message);
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
