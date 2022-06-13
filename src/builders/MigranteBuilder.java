package builders;

import users.Migrante;

public class MigranteBuilder {
	private String nome;
	private String tele;
	private String[] familia;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public void setFamilia(String[] familia) {
		this.familia = familia;
	}
	
	public Migrante getMigrante() {
		if(familia == null || familia.length == 0)
			return new Migrante(nome, tele);
		else
			return new Migrante(nome, tele, familia);
	}
}
