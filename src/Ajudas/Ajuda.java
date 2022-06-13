package Ajudas;

import Users.*;

public abstract class Ajuda {
	protected Migrante migrante;
	protected Voluntario voluntario;

	protected Ajuda(Migrante migrante, Voluntario voluntario) {
		this.migrante = migrante;
		this.voluntario = voluntario;
	}

	public Migrante getMigrante() {
		return migrante;
	}

	public Voluntario getvoluntario() {
		return voluntario;
	}
}
