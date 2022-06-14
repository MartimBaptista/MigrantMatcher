package builders;

import ajudas.*;
import users.*;

public class AjudaBuilder {
	private Migrante migrante;
	private Voluntario voluntario;
	private String descricao;
	private int capacidade;
	private String regiao;
	
	public void setMigrante(Migrante migrante) {
		this.migrante = migrante;
	}
	
	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	
	public void setDescription(String descricao) {
		this.descricao = descricao;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	public Alojamento getAlojamento() {
		return new Alojamento(voluntario, capacidade, regiao);
	}
	
	public Item getItem() {
		return new Item(voluntario, descricao);
	}
}