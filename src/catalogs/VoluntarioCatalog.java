package catalogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import users.Voluntario;

public class VoluntarioCatalog implements CatalogInterface<Voluntario> {
	private static VoluntarioCatalog instance = new VoluntarioCatalog();
	private Map<String, Voluntario> catalog;

	private VoluntarioCatalog() {
		catalog = new HashMap<>();
	}

	public static VoluntarioCatalog getInstance() {
		return instance;
	}

	@Override
	public void put(String tele, Voluntario voluntario) {
		catalog.put(tele, voluntario);
	}

	@Override
	public Voluntario get(String tele) {
		return catalog.get(tele);
	}

	@Override
	public Collection<Voluntario> getValues() {
		return catalog.values();
	}
}
