package Catalogs;

import java.util.HashMap;
import java.util.Map;
import Ajudas.Ajuda;
import Users.Migrante;

public class AjudaCatalog {
	private static AjudaCatalog instance;
	private Map<Integer, Ajuda> catalog;
	
	private AjudaCatalog() {
		catalog = new HashMap<>();
	}
	
	public static AjudaCatalog getInstance(){
		if(instance == null){
			return new AjudaCatalog();
		}
		else {
			return instance;
		}
	}
	
	public void registarAjuda(int id, Ajuda ajuda){
		catalog.put(id, ajuda);
	}
	
	public Ajuda obterAjuda(int id) {
		return catalog.get(id);
	}
}
