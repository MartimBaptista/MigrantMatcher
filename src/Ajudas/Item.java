package ajudas;

import users.*;;

public class Item extends Ajuda {
	private String descricao;

	public Item(Migrante migrante, Voluntario voluntario, String descricao) {
		super(migrante, voluntario);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
