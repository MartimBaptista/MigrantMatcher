package tests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ajudas.*;
import catalogs.AjudaCatalog;
import catalogs.MigranteCatalog;
import config.Configuration;
import handlers.PedeAjudaHandler;
import sms.PidgeonSMSAdapter;
import sms.TelegramSMSAdapter;
import sorters.SortByDate;
import sorters.SortByType;
import users.Migrante;
import users.Voluntario;

class UseCase2 {

	@Test
	void test() throws IOException {
		// Voluntarios e ajudas:
		String[] numerosItem = { "939221811", "919293911", "934829137" };
		String[] descricaoItem = { "Alimentos", "Roupa", "Produtos de igiene" };

		String[] numerosAloj = { "939491806", "923456295", "919457143", "932658193", "923850158" };
		int[] tamanhosAloj = { 1, 3, 4, 3, 3 };
		String[] regioesAloj = { "Lisboa", "Lisboa", "Porto", "Algarve", "Leiria" };

		// Migrantes:
		String[] nomesIndiv = { "Ivan", "Oleksiy" };
		String[] telesIndiv = { "050189405", "067294736" };
		String[] regioesIndiv = { "Lisboa", "Porto" };

		String[] nomesFam = { "Petro", "Kateryna", "Christian" };
		String[] telesFam = { "044636748", "050847201", "067826493" };
		String[][] familias = { { "Rudi", "Vlasta" }, { "Pishta" }, { "Alina", "Maryana", "Anatoliy" } };
		String[] regioesFam = { "Algarve", "Lisboa", "Leiria" };

		// Criar os Voluntarios e Ajudas pelo Handler (criar os Items primeiro para
		// poder testas os diferentes sorters)
		for (int i = 0; i < numerosItem.length; i++) {
			TestingTools.setupVolItem(numerosItem[i], descricaoItem[i]);
		}
		for (int i = 0; i < numerosAloj.length; i++) {
			TestingTools.setupVolAlojamento(numerosAloj[i], tamanhosAloj[i], regioesAloj[i]);
		}

		// Redirecionar o output
		ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		// Criar os Migrantes pelo Hanlder (e testar)

		MigranteCatalog migrantes = MigranteCatalog.getInstance();
		AjudaCatalog ajudaCatalog = AjudaCatalog.getInstance();

		for (int i = 0; i < nomesIndiv.length; i++) {
			PedeAjudaHandler handler = new PedeAjudaHandler();
			Ajuda[] ajudas = TestingTools.setupMigranteIndividual(handler, nomesIndiv[i], telesIndiv[i],
					regioesIndiv[i]);

			// Testar o registo dos migrantes
			Migrante migrante = migrantes.get(telesIndiv[i]);
			Assertions.assertEquals(nomesIndiv[i], migrante.getNome());
			Assertions.assertEquals(telesIndiv[i], migrante.getTele());

			// Testar caso a caso
			switch (i) {
			case 0: { // Ivan
				testCase(ajudas, ajudaCatalog, migrante, handler, new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 3 }, out,
						false);
				break;
			}
			case 1: { // Oleksiy
				testCase(ajudas, ajudaCatalog, migrante, handler, new int[] { 1, 2, 5 }, new int[] { 2 }, out, false);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		}
		for (int i = 0; i < nomesFam.length; i++) {
			PedeAjudaHandler handler = new PedeAjudaHandler();
			Ajuda[] ajudas = TestingTools.setupMigranteFamilia(handler, nomesFam[i], telesFam[i], familias[i],
					regioesFam[i]);

			// Testar o registo dos migrantes
			Migrante migrante = migrantes.get(telesFam[i]);
			Assertions.assertEquals(nomesFam[i], migrante.getNome());
			Assertions.assertEquals(telesFam[i], migrante.getTele());
			Assertions.assertArrayEquals(familias[i], migrante.getFamilia());

			// Testar caso a caso
			switch (i) {
			case 0: { // Petro
				testCase(ajudas, ajudaCatalog, migrante, handler, new int[] { 1, 6 }, new int[] { 6 }, out, false);
				break;
			}
			case 1: { // Kateryna
				testCase(ajudas, ajudaCatalog, migrante, handler, new int[] { 1, 4 }, new int[] { 4 }, out, false);
				break;
			}
			case 2: { // Christian
				testCase(ajudas, ajudaCatalog, migrante, handler, new int[] { 1 }, new int[] {}, out, true);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		}
		// Testar a notificaçao aos Migrantes
		TestingTools.setupVolAlojamento("939234321", 3, "Leiria");
		String[] allLines = out.toString().split("\n"); // have to do this because flush doesn't work on OutputStream :/
		String[] message = allLines[allLines.length - 1].split(" ");
		Assertions.assertEquals("067826493:", message[1]);

	}

	private void testCase(Ajuda[] ajudas, AjudaCatalog ajudaCatalog, Migrante migrante, PedeAjudaHandler handler,
			int[] ajudasEsperadas, int[] ajudasEscolhidas, ByteArrayOutputStream out, boolean ativarNotificacao)
			throws IOException {

		// Verificar ajudasDispoiveis
		Assertions.assertEquals(ajudasEsperadas.length, ajudas.length);
		testSortOrder(ajudas);
		for (int i = 0; i < ajudasEsperadas.length; i++) {
			Assertions.assertNotNull(TestingTools.getAjudaWithID(ajudas, ajudasEsperadas[i]));
		}

		// Atribuir ajudas ao Migrante (e testar notificaçao ao voluntario)
		for (int i = 0; i < ajudasEscolhidas.length; i++) {
			handler.indicaAjuda(TestingTools.getAjudaWithID(ajudas, ajudasEscolhidas[i]));
			testNotification(out, TestingTools.getAjudaWithID(ajudas, ajudasEscolhidas[i]).getvoluntario());
		}

		// Verificar a atribuicao das ajudas
		for (int i = 0; i < ajudasEscolhidas.length; i++) {
			Assertions.assertEquals(migrante, ajudaCatalog.get(String.valueOf(ajudasEscolhidas[i])).getMigrante());
		}
		if (ativarNotificacao)
			handler.ativarNotificacao();
	}

	private void testSortOrder(Ajuda[] ajudas) {
		if (Configuration.getInstance().getInstanceOfClass("sortType", null) instanceof SortByDate) {
			int last = -1;
			for (int i = 0; i < ajudas.length; i++) {
				if (last > ajudas[i].getId())
					Assertions.fail();
			}
		} else if (Configuration.getInstance().getInstanceOfClass("sortType", null) instanceof SortByType) {
			boolean changed = false;
			for (int i = 0; i < ajudas.length; i++) {
				if (ajudas[i] instanceof Alojamento && changed)
					Assertions.fail();
				else if (ajudas[i] instanceof Item)
					changed = true;
				;
			}
		}
	}

	private void testNotification(ByteArrayOutputStream output, Voluntario voluntario) throws IOException {
		String[] allLines = output.toString().split("\n"); // have to do this because flush doesn't work on OutputStream
															// :/
		String[] message = allLines[allLines.length - 1].split(" ");

		// Caso Pidgeon:
		if (Configuration.getInstance().getInstanceOfClass("smsProvider", null) instanceof PidgeonSMSAdapter)
			Assertions.assertEquals("{SMSSender}", message[0]);
		// Caso Telegram:
		else if (Configuration.getInstance().getInstanceOfClass("smsProvider", null) instanceof TelegramSMSAdapter)
			Assertions.assertEquals("{TelegramSMSSender}", message[0]);
		// Verificar tele
		Assertions.assertEquals(voluntario.getTele() + ":", message[1]);
	}
}
