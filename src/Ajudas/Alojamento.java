package Ajudas;

import Users.*;

public class Alojamento extends Ajuda {
	private int capacity;
	private String regiao;
	
	public Alojamento(Migrante migrante, Voluntario voluntario, int capacity, String regiao) {
		super(migrante, voluntario);
		this.capacity = capacity;
		this.regiao = regiao;
	}
	
	int getCapacity() {
		return this.capacity;
	}
	
	String getregiao() {
		return this.regiao;
	}
}
