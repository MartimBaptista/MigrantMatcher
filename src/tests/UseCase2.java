package tests;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ajudas.*;
import catalogs.MigranteCatalog;
import handlers.PedeAjudaHandler;
import handlers.RegistaAjudaHandler;
import notificacoes.NotificadorMigrante;
import users.Migrante;

class UseCase2 {

	@Test
	void test() {
		//Rgistar Ajuda e Voluntario
		RegistaAjudaHandler handler1 = new RegistaAjudaHandler();
		handler1.indicaVoluntario("939491806");
		handler1.indicaNumDePessoas(3);
		handler1.indicaRegiao("Lisboa");
		String codigo = handler1.enviarCodigo();
		handler1.confirmaCodigo(codigo);
		handler1.finalizarAjuda();
		
		RegistaAjudaHandler handler2 = new RegistaAjudaHandler();
		handler2.indicaVoluntario("93949123");
		handler2.descreveItem("Old computer");
		codigo = handler1.enviarCodigo();
		handler2.confirmaCodigo(codigo);
		handler2.finalizarAjuda();
		
		
		//Registar Migrante
		PedeAjudaHandler handler3 = new PedeAjudaHandler();
		handler3.indicaNomeMigrante("Volodomyr");
		handler3.indicaTeleMigrante("902103956");
		handler3.indicaNumFamiliar(3);
		handler3.indicaFamiliar("Vasily");
		handler3.indicaFamiliar("Viktor");
		handler3.indicaFamiliar("Vladislav");
		handler3.registarMigrante();
		handler3.registaRegiao("Lisboa");
		Collection<Ajuda> ajudasCollection = handler3.ajudasDisponiveis();
		Ajuda[] ajudas = ajudasCollection.toArray(new Ajuda[ajudasCollection.size()]);
		Assertions.assertEquals(3, ((Alojamento) ajudas[0]).getCapacity());
		Assertions.assertEquals("Lisboa", ((Alojamento) ajudas[0]).getRegiao());
		Assertions.assertEquals("Old computer", ((Item) ajudas[1]).getDescricao());
		
		handler3.ativarNotificacao();
		
		//Testar que foi guardado
		MigranteCatalog catalogo = MigranteCatalog.getInstance(); 
		
		Assertions.assertNotNull(catalogo.get("902103956"));
		Migrante migrante = catalogo.get("902103956");
		Assertions.assertEquals("902103956", migrante.getTele());
		
		//Testar se familiar foi guardado
		String familiar2 = migrante.getFamilia()[1];
		Assertions.assertEquals("Viktor", familiar2);
		
		//Testar se notificação foi ativada
		
	}

}
