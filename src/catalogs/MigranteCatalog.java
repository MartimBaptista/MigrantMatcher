package catalogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import users.Migrante;

public class MigranteCatalog implements CatalogInterface<Migrante> {
	private static MigranteCatalog instance = new MigranteCatalog();
	private Map<String, Migrante> catalog;

	private MigranteCatalog() {
		catalog = new HashMap<>();
	}

	public static MigranteCatalog getInstance() {
		return instance;
	}

	@Override
	public void put(String tele, Migrante migrante) {
		catalog.put(tele, migrante);
	}

	@Override
	public Migrante get(String tele) {
		return catalog.get(tele);
	}

	@Override
	public Collection<Migrante> getValues() {
		return catalog.values();
	}

}
