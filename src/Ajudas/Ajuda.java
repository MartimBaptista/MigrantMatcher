package Ajudas;

import Users.*;

public abstract class Ajuda {
	protected Migrante migrante;
	protected Voluntario voluntario;

	protected Ajuda(Migrante migrante, Voluntario voluntario) {
		this.migrante = migrante;
		this.voluntario = voluntario;
	}

	Migrante getMigrante() {
		return migrante;
	}

	Voluntario getvoluntario() {
		return voluntario;
	}
}
