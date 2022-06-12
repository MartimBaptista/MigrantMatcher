package Ajudas;

import Users.*;;

public class Item extends Ajuda {
	private String discricao;

	public Item(Migrante migrante, Voluntario voluntario, String discricao) {
		super(migrante, voluntario);
		this.discricao = discricao;
	}

	public String getDescricao() {
		return discricao;
	}
}
