package ajudas;

import java.time.LocalDateTime;

import users.*;


public abstract class Ajuda {
	protected LocalDateTime submitedTime;
	protected Migrante migrante;
	protected Voluntario voluntario;

	protected Ajuda(Voluntario voluntario) {
		this.submitedTime = LocalDateTime.now();
		this.voluntario = voluntario;
	}
	
	public LocalDateTime getSubmitedTime() {
		return submitedTime;
	}
	
	public Voluntario getvoluntario() {
		return voluntario;
	}
	
	public Migrante assignMigrante() {
		return migrante;
	}

	public Migrante getMigrante() {
		return migrante;
	}

}
