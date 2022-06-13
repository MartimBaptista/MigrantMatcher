package Ajudas;

import Users.*;

public abstract class Ajuda {
	protected Migrante migrante;
	protected Voluntario voluntario;

	private static final String[] regioes = { "Alentejo Central", "Alentejo Litoral", "Alto Alentejo", "Baixo Alentejo",
			"Leziria do Tejo", "Algarve", "Beira Baixa", "Beiras e Serra da Estrela", "Medio Tejo", "Aveiro", "Coimbra",
			"Leiria", "Viseu", "Lisboa", "Alto Minho", "Alto Tamega", "Porto", "Ave", "Cavado", "Douro",
			"Tamega e Sousa", "Tras-os-Montes" };

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

	public String[] getRegioes() {
		return regioes;
	}
}
