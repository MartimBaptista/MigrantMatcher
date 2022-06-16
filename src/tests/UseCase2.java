package tests;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import catalogs.MigranteCatalog;
import handlers.PedeAjudaHandler;
import notificacoes.NotificadorMigrante;
import users.Migrante;

class UseCase2 {

	@Test
	void test() {
		//Registar Migrante
		PedeAjudaHandler handler = new PedeAjudaHandler();
		handler.indicaNomeMigrante("Volodomyr");
		handler.indicaTeleMigrante("902103956");
		handler.indicaNumFamilia(3);
		handler.indicaFamiliar("Vasily");
		handler.indicaFamiliar("Viktor");
		handler.indicaFamiliar("Vladislav");
		handler.registarMigrante();
		handler.registaRegiao("Lisboa");
		handler.ativarNotificacao();
		
		//Testar que foi guardado
		MigranteCatalog catalogo = MigranteCatalog.getInstance(); 
		
		Assertions.assertNotNull(catalogo.get("902103956"));
		Migrante migrante = catalogo.get("902103956");
		Assertions.assertEquals("902103956", migrante.getTele());
		
		//Testar se familiar foi guardado
		String familiar2 = migrante.getFamilia()[1];
		Assertions.assertEquals("Viktor", familiar2);
		
		//Testar se notificação foi ativada
		NotificadorMigrante notifs = NotificadorMigrante.getInstance();
		Collection<Migrante> migrantesSubs = notifs.getSubscribers().get("Lisboa");
		Assertions.assertTrue(migrantesSubs.contains(migrante));
		
	}

}
