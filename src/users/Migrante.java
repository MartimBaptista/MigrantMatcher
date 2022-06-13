package Users;

public class Migrante {
	private String nome;
	private String tele;
	private String[] familia;
	
	public Migrante(String nome, String tele) {
		this.nome = nome;
		this.tele = tele;
	}
	
	public Migrante(String nome, String tele, String[] familia) {
		this.nome = nome;
		this.tele = tele;
		this.familia = familia;
	}
	
	public String getTele() {
		return this.tele;
	}

}
