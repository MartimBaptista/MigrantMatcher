package Catalogs;

import java.util.HashMap;
import java.util.Map;

import Users.Migrante;

public class MigranteCatalog {
	private static MigranteCatalog instance;
	private Map<Integer, Migrante> catalog;

	private MigranteCatalog() {
		catalog = new HashMap<>();
	}

	public static MigranteCatalog getInstance() {
		if (instance == null) {
			return new MigranteCatalog();
		} else {
			return instance;
		}
	}

	public void registarMigrante(int tele, Migrante migrante) {
		catalog.put(tele, migrante);
	}

	public Migrante obterMigrante(int tele) {
		return catalog.get(tele);
	}
}
