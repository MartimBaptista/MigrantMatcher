package users;

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

	public String getNome() {
		return this.nome;
	}

	public String getTele() {
		return this.tele;
	}

	public String[] getFamilia() {
		return this.familia;
	}
}
