package ajudas;

import users.*;

public class Alojamento extends Ajuda {
	private int capacidade;
	private String regiao;

	public Alojamento(Voluntario voluntario, int capacity, String regiao) {
		super(voluntario);
		this.capacidade = capacity;
		this.regiao = regiao;
	}

	public int getCapacity() {
		return this.capacidade;
	}

	public String getRegiao() {
		return this.regiao;
	}
}
