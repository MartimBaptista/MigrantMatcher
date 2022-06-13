package Handlers;


public class RegistaAjudaHandler {
	private static RegistaAjudaHandler instance;

	private RegistaAjudaHandler() {
		//TODO
	}

	public static RegistaAjudaHandler getInstance() {
		if (instance == null) {
			return new RegistaAjudaHandler();
		} else {
			return instance;
		}
	}
	
	
	
	
	/*
	 * private Ajuda ajuda;
	 * 
	 * public void indicaVoluntario(int tele) { //criar voluntario
	 * 
	 * } //para Ajuda do tipo alojamento public void indicaNumPessoas(int num) {
	 * 
	 * }
	 * 
	 * public void indicaRegiao(String regiao) {
	 * 
	 * } //para Ajuda do tipo Item public void descreveItem(String desc) {
	 * this.ajuda = new Item(desc);
	 * 
	 * }
	 * 
	 * public void confirmarCodigo(int codUser) {
	 * 
	 * }
	 */
	//As regioes teem de ser de uma lista predefenida
}
