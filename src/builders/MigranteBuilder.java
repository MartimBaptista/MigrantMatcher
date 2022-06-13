package builders;

import users.Migrante;

public class MigranteBuilder {
	private String nome;
	private String tele;
	private String[] familia;
	private int indice;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public void setFamiliaSize(int size) {
		this.familia = new String[size];
		this.indice = 0;
	}
	
	public void addFamiliar(String nome) {
		this.familia[this.indice] = nome;
		this.indice++;
	}

	public Migrante getMigrante() {
		if(familia == null || familia.length == 0)
			return new Migrante(nome, tele);
		else
			return new Migrante(nome, tele, familia);
	}
}
