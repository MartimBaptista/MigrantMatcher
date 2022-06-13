package catalogs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import users.Voluntario;

public class VoluntarioCatalog implements CatalogInterface<Voluntario> {
	private static VoluntarioCatalog instance;
	private Map<String, Voluntario> catalog;

	private VoluntarioCatalog() {
		catalog = new HashMap<>();
	}

	public static VoluntarioCatalog getInstance() {
		if (instance == null) {
			return new VoluntarioCatalog();
		} else {
			return instance;
		}
	}

	@Override
	public void set(String tele, Voluntario voluntario) {
		catalog.put(tele, voluntario);
	}

	@Override
	public Voluntario get(String tele) {
		return catalog.get(tele);
	}

	@Override
	public Iterator<Voluntario> getIterator() {
		return catalog.values().iterator();
	}
}
