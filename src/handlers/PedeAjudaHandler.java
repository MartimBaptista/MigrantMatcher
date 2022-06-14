package handlers;

import catalogs.*;

import java.util.Collection;

import ajudas.Ajuda;
import builders.MigranteBuilder;
import users.Migrante;

public class PedeAjudaHandler {
	private VoluntarioCatalog voluntarioCatalog;
	private AjudaCatalog ajudaCatalog;
	private MigranteCatalog migranteCatalog;
	private MigranteBuilder mb;

	public PedeAjudaHandler() {
		voluntarioCatalog = VoluntarioCatalog.getInstance();
		ajudaCatalog = AjudaCatalog.getInstance();
		migranteCatalog = MigranteCatalog.getInstance();
		mb = new MigranteBuilder();
	}
	
	public void indicaMigrante(String nome, String tele) {
		mb.setNome(nome);
		mb.setTele(tele);
	}
	
	public void indicaNumFamilia(int num) {
		mb.setFamiliaSize(num);
	}
	
	public void indicaFamiliar(String nome) {
		mb.addFamiliar(nome);
	}

	public void indicaRegiao(String reg) {
		//TODO	
	}
	
	public void ativarNotificacao() {
		//TODO	
	}
	
	public void notificaDepois() {
		//TODO	
	}
	
	public Collection<Ajuda> availableAjudas(String regiao){
		//TODO
		return null;
	}
	
	public void indicaAjuda(Ajuda ajuda) {
		//TODO	
	}
	
	public void confirmar() {
		Migrante mig = mb.getMigrante();
		migranteCatalog.set(mig.getTele(), mig);
		//TODO
	}
}
