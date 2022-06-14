package ajudas;

import users.*;;

public class Item extends Ajuda {
	private String descricao;

	public Item(Voluntario voluntario, String descricao) {
		super(voluntario);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
