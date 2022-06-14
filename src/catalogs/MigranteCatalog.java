package catalogs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import users.Migrante;

public class MigranteCatalog implements CatalogInterface<Migrante> {
	private static MigranteCatalog instance;
	private Map<String, Migrante> catalog;

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

	@Override
	public void put(String tele, Migrante migrante) {
		catalog.put(tele, migrante);
	}

	@Override
	public Migrante get(String tele) {
		return catalog.get(tele);
	}

	@Override
	public Iterator<Migrante> getIterator() {
		return catalog.values().iterator();
	}

}
