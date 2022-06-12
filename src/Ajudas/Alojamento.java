package Ajudas;

import Users.*;

public class Alojamento extends Ajuda {
	private int capacidade;
	private String regiao;
	
	public Alojamento(Migrante migrante, Voluntario voluntario, int capacity, String regiao) {
		super(migrante, voluntario);
		this.capacidade = capacity;
		this.regiao = regiao;
	}
	
	int getCapacity() {
		return this.capacidade;
	}
	
	String getregiao() {
		return this.regiao;
	}
}
