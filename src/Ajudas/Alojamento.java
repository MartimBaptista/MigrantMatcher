package Ajudas;

import Users.*;

public class Alojamento extends Ajuda {
	private int capacidade;
	private String regiao;
	private static final String[] regioes = {
											"Alentejo Central",
											"Alentejo Litoral",
											"Alto Alentejo",
											"Baixo Alentejo",
											"Leziria do Tejo",
											"Algarve",
											"Beira Baixa",
											"Beiras e Serra da Estrela",
											"Medio Tejo",
											"Aveiro",
											"Coimbra",
											"Leiria",
											"Viseu",
											"Lisboa",
											"Alto Minho",
											"Alto Tamega",
											"Porto",
											"Ave",
											"Cavado",
											"Douro",
											"Tamega e Sousa",
											"Tras-os-Montes"};
	
	public Alojamento(Migrante migrante, Voluntario voluntario, int capacity, String regiao) {
		super(migrante, voluntario);
		this.capacidade = capacity;
		this.regiao = regiao;
	}
	
	public int getCapacity() {
		return this.capacidade;
	}
	
	public String getRegiao() {
		return this.regiao;
	}
	
	public String[] getRegioes() {
		return regioes;
	}
	
}
