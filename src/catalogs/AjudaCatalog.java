package catalogs;

import java.util.HashMap;
import java.util.Map;

import ajudas.Ajuda;


public class AjudaCatalog implements CatalogInterface<Ajuda> {
	private static AjudaCatalog instance = new AjudaCatalog();
	private Map<String, Ajuda> catalog;
	private int ajudaID;

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
	public Ajuda[] getValues() {
		return catalog.values().toArray(new Ajuda[catalog.size()]);
	}
	
	public int getIDConter() {
		return ajudaID;
	}
	
	public void increaseIDConter() {
		ajudaID++;
	}
}
