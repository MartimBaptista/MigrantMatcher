package tests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
	
	static Collection<Ajuda> setupMigranteFamilia(String nome, String tele, int numFamilia, String[] familiares, String regiao) {
		PedeAjudaHandler handler = new PedeAjudaHandler();
		handler.indicaNomeMigrante(nome);
		handler.indicaTeleMigrante(tele);
		handler.indicaNumFamiliar(numFamilia);
		for (int i = 0; i < familiares.length; i++) {
			handler.indicaFamiliar(familiares[i]);
		}
		handler.registarMigrante();
		handler.registaRegiao(regiao);
		return handler.ajudasDisponiveis();
	}
	
	static Collection<Ajuda> setupMigranteIndividual(String nome, String tele, String regiao) {
		PedeAjudaHandler handler = new PedeAjudaHandler();
		handler.indicaNomeMigrante(nome);
		handler.indicaTeleMigrante(tele);
		handler.registarMigrante();
		handler.registaRegiao(regiao);
		return handler.ajudasDisponiveis();
	}
}
