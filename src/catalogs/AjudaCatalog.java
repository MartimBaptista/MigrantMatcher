package catalogs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ajudas.Ajuda;

public class AjudaCatalog implements CatalogInterface<Ajuda> {
	private static AjudaCatalog instance;
	private Map<String, Ajuda> catalog;

	private AjudaCatalog() {
		catalog = new HashMap<>();
	}

	public static AjudaCatalog getInstance() {
		if (instance == null) {
			return new AjudaCatalog();
		} else {
			return instance;
		}
	}

	@Override
	public void set(String id, Ajuda ajuda) {
		catalog.put(id, ajuda);
	}

	@Override
	public Ajuda get(String id) {
		return catalog.get(id);
	}

	@Override
	public Iterator<Ajuda> getIterator() {
		return catalog.values().iterator();
	}
}
