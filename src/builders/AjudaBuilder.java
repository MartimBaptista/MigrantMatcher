package builders;

import ajudas.*;
import users.*;

public class AjudaBuilder {
	private Voluntario voluntario;
	private String descricao;
	private int capacidade;
	private String regiao;
	
	
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
	
	public Ajuda getAjuda() {
		if(capacidade > 0 && regiao != null && regiao.length() > 0)
			return new Alojamento(voluntario, capacidade, regiao);
		else
			return new Item(voluntario, descricao);
	}
}