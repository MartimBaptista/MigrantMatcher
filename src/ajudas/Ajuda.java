package ajudas;

import users.*;

public abstract class Ajuda {
	protected int id;
	protected Migrante migrante;
	protected Voluntario voluntario;

	protected Ajuda(int id, Voluntario voluntario) {
		this.id = id;
		this.voluntario = voluntario;
	}

	public int getId() {
		return id;
	}

	public Voluntario getvoluntario() {
		return voluntario;
	}

	public void assignMigrante(Migrante migrante) {
		this.migrante = migrante;
	}

	public Migrante getMigrante() {
		return migrante;
	}

}
