package handlers;

import catalogs.*;
import sorters.Sorter;

import java.util.Collection;

import ajudas.Ajuda;
import builders.MigranteBuilder;
import users.Migrante;

public class PedeAjudaHandler {
	private VoluntarioCatalog voluntarioCatalog;
	private AjudaCatalog ajudaCatalog;
	private MigranteCatalog migranteCatalog;
	private MigranteBuilder mb;
	private Sorter sorter;

	public PedeAjudaHandler(Sorter sorter) {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		migranteCatalog = MigranteCatalog.getInstance();
		mb = new MigranteBuilder();
		this.sorter = sorter;
	}
	
	public void indicaNomeMigrante(String nome) {
		mb.setNome(nome);
	}
	
	public void indicaTeleMigrante(String tele) {
		mb.setTele(tele);
	}
	
	public void indicaNumFamilia(int num) {
		mb.setFamiliaSize(num);
	}
	
	public void indicaFamiliar(String nome) {
		mb.addFamiliar(nome);
	}
	
	public Collection<String> regioesDisponiveis(){
		//TODO
		return null;
	}
	
	public Collection<Ajuda> ajudasDisponiveis(String regiao){
		//TODO
		return null;
	}
	
	public void ativarNotificacao() {
		//TODO	
	}
	
	public void notificaDepois() {
		//TODO	
	}
	
	public void indicaAjuda(Ajuda ajuda) {
		//TODO	
	}
	
	public void confirmar() {
		Migrante mig = mb.getMigrante();
		migranteCatalog.put(mig.getTele(), mig);
		//TODO
	}
}
