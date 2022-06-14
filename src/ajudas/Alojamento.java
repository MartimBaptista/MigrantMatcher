package ajudas;

import notificacoes.Notificador;
import users.*;

public class Alojamento extends Ajuda {
	private int capacidade;
	private String regiao;

	public Alojamento(int id, Voluntario voluntario, int capacity, String regiao) {
		super(id, voluntario);
		this.capacidade = capacity;
		this.regiao = regiao;
		Notificador.getInstance().notificar(regiao);
	}

	public int getCapacity() {
		return this.capacidade;
	}

	public String getRegiao() {
		return this.regiao;
	}
}
