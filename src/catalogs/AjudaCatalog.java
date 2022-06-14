package catalogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ajudas.Ajuda;
import sorters.Sorter;
import sorters.sortByDate;
import config.Configuration;

public class AjudaCatalog implements CatalogInterface<Ajuda> {
	private static AjudaCatalog instance;
	private Sorter sorter;
	private Map<String, Ajuda> catalog;

	private AjudaCatalog() {
		catalog = new HashMap<>();
		sorter = Configuration.getInstance().getInstanceOfClass("sortType", new sortByDate());
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
	
	public Collection<Ajuda> getSortedAjudas(){
		return sorter.sort(catalog.values());
	}
}
