package handlers;

import catalogs.*;
import config.Configuration;
import notificacoes.NotificadorMigrante;
import notificacoes.NotificadorVoluntario;
import sorters.*;

import java.util.Collection;

import ajudas.Ajuda;
import ajudas.Alojamento;
import builders.MigranteBuilder;
import users.Migrante;

public class PedeAjudaHandler {
	private MigranteCatalog migranteCatalog;
	private AjudaCatalog ajudaCatalog;
	private MigranteBuilder mb;
	private Migrante migrante;
	private String regiao;
	private static Sorter sorter = Configuration.getInstance().getInstanceOfClass("sortType", new SortByDate());

	public PedeAjudaHandler() {
		this.migranteCatalog = MigranteCatalog.getInstance();
		this.ajudaCatalog = AjudaCatalog.getInstance();
		this.mb = new MigranteBuilder();
	}
	
	public void indicaNomeMigrante(String nome) {
		this.mb.setNome(nome);
	}
	
	public void indicaTeleMigrante(String tele) {
		this.mb.setTele(tele);
	}
	
	public void indicaNumFamiliar(int num) {
		this.mb.setFamiliaSize(num);
	}
	
	public void indicaFamiliar(String nome) {
		this.mb.addFamiliar(nome);
	}
	
	public void registarMigrante() {
		this.migrante = mb.getMigrante();
		this.migranteCatalog.put(migrante.getTele(), migrante);
	}
	
	public void registaRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	
	public Ajuda[] ajudasDisponiveis(){
		Collection<Ajuda> res = ajudaCatalog.getValues();
		for (Ajuda ajuda : res) {
			if(ajuda.getMigrante() != null)
				res.remove(ajuda);
			if(ajuda instanceof Alojamento) {
				Alojamento alojamento = (Alojamento) ajuda;
				if(alojamento.getRegiao() != regiao) {
					if(migrante.getFamilia() != null)
						if(alojamento.getCapacity() < migrante.getFamilia().length + 1)
							res.remove(ajuda);
				}
			}
		}
		sorter.sort(res);
		return res.toArray(new Ajuda[res.size()]);
	}
	
	
	public void indicaAjuda(Ajuda ajuda) {
		ajuda.assignMigrante(migrante);
		NotificadorVoluntario.getInstance().notificar(ajuda.getId());
	}
	
	public void ativarNotificacao() {
		NotificadorMigrante.getInstance().subscribe(this.migrante, this.regiao);
	}
}
