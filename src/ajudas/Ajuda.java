package ajudas;

import users.*;


public abstract class Ajuda {
	protected Migrante migrante;
	protected Voluntario voluntario;

	protected Ajuda(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	
	public Migrante assignMigrante() {
		return migrante;
	}

	public Migrante getMigrante() {
		return migrante;
	}

	public Voluntario getvoluntario() {
		return voluntario;
	}
}
