package ajudas;

import notificacoes.NotificadorMigrante;
import users.*;

public class Alojamento extends Ajuda {
	private int capacidade;
	private String regiao;

	public Alojamento(int id, Voluntario voluntario, int capacity, String regiao) {
		super(id, voluntario);
		this.capacidade = capacity;
		this.regiao = regiao;
		NotificadorMigrante.getInstance().notificar(regiao);
	}

	public int getCapacity() {
		return this.capacidade;
	}

	public String getRegiao() {
		return this.regiao;
	}

	public String toString() {
		return ("Alojamento para " + this.capacidade + " pessoa(s), em " + this.regiao + ".");
	}
}
