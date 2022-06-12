package Catalogs;

import java.util.HashMap;
import java.util.Map;

import Users.Voluntario;

public class VoluntarioCatalog {
	private static VoluntarioCatalog instance;
	private Map<Integer, Voluntario> catalog;

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

	public void registarVoluntario(int tele, Voluntario voluntario) {
		catalog.put(tele, voluntario);
	}

	public Voluntario obterVoluntario(int tele) {
		return catalog.get(tele);
	}
}
