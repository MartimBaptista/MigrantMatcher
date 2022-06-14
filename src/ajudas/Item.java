package ajudas;

import users.*;;

public class Item extends Ajuda {
	private String descricao;

	public Item(int id, Voluntario voluntario, String descricao) {
		super(id, voluntario);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public String toString() {
		return (descricao);
	}
}
