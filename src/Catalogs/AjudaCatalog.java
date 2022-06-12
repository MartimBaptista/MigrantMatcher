package Catalogs;

import java.util.HashMap;
import java.util.Map;
import Ajudas.Ajuda;

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
}
