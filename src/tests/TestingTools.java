package tests;

import ajudas.Ajuda;
import handlers.PedeAjudaHandler;
import handlers.RegistaAjudaHandler;

public class TestingTools {
	static void setupVolAlojamento(String tele, int capacidade, String regiao) {
		RegistaAjudaHandler handler = new RegistaAjudaHandler();
		handler.indicaVoluntario(tele);
		handler.indicaNumDePessoas(capacidade);
		handler.indicaRegiao(regiao);
		String codigo = handler.enviarCodigo();
		handler.confirmaCodigo(codigo);
		handler.finalizarAjuda();
	}
	
	static void setupVolItem(String tele, String descricao) {
		RegistaAjudaHandler handler = new RegistaAjudaHandler();
		handler.indicaVoluntario(tele);
		handler.descreveItem(descricao);
		String codigo = handler.enviarCodigo();
		handler.confirmaCodigo(codigo);
		handler.finalizarAjuda();
	}
	
	static Ajuda[] setupMigranteFamilia(PedeAjudaHandler handler, String nome, String tele, String[] familiares, String regiao) {
		handler.indicaNomeMigrante(nome);
		handler.indicaTeleMigrante(tele);
		handler.indicaNumFamiliar(familiares.length);
		for (int i = 0; i < familiares.length; i++) {
			handler.indicaFamiliar(familiares[i]);
		}
		handler.registarMigrante();
		handler.registaRegiao(regiao);
		return handler.ajudasDisponiveis();
	}
	
	static Ajuda[] setupMigranteIndividual(PedeAjudaHandler handler, String nome, String tele, String regiao) {
		handler.indicaNomeMigrante(nome);
		handler.indicaTeleMigrante(tele);
		handler.registarMigrante();
		handler.registaRegiao(regiao);
		return handler.ajudasDisponiveis();
	}
	
	static Ajuda getAjudaWithID(Ajuda[] ajudas, int ID) {
		for (int i = 0; i < ajudas.length; i++) {
			Ajuda ajuda = ajudas[i];
			if(ajuda.getId() == ID)
				return ajuda;
		}
		return null;
	}
}
