package catalogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ajudas.Ajuda;


public class AjudaCatalog implements CatalogInterface<Ajuda> {
	private static AjudaCatalog instance = new AjudaCatalog();
	private Map<String, Ajuda> catalog;

	private AjudaCatalog() {
		catalog = new HashMap<>();
	}

	public static AjudaCatalog getInstance() {
		return instance;
	}

	@Override
	public void put(String id, Ajuda ajuda) {
		catalog.put(id, ajuda);
	}

	@Override
	public Ajuda get(String id) {
		return catalog.get(id);
	}

	@Override
	public Collection<Ajuda> getValues() {
		return catalog.values();
	}
}
