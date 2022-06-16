package handlers;

import catalogs.*;
import config.Configuration;
import notificacoes.NotificadorMigrante;
import notificacoes.NotificadorVoluntario;
import sorters.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
		Ajuda[] res = ajudaCatalog.getValues();
		List<Ajuda> toRemove = new ArrayList<>(); 									// To avoid ConcurrentModificationException
		for (Ajuda ajuda : res) {
			if(ajuda.getMigrante() != null) 										//check if not taken
				toRemove.add(ajuda);
			if(ajuda instanceof Alojamento) { 										//check if instanceof Alojamento
				Alojamento alojamento = (Alojamento) ajuda;
				if(alojamento.getRegiao() != regiao) 								//check if the same region
					toRemove.add(ajuda);
				if(migrante.getFamilia() != null)									//check if migrante has a family
					if(alojamento.getCapacity() < migrante.getFamilia().length + 1) //check if enough space for family
						toRemove.add(ajuda);
			}
		}
		// I hate this, but it works just fine
		List<Ajuda> resList = new LinkedList<>(Arrays.asList(res));
		resList.removeAll(toRemove);
		res = resList.toArray(new Ajuda[resList.size()]);
		sorter.sort(res);
		return res;
	}
	
	
	public void indicaAjuda(Ajuda ajuda) {
		ajuda.assignMigrante(migrante);
		NotificadorVoluntario.getInstance().notificar(ajuda.getId());
	}
	
	public void ativarNotificacao() {
		NotificadorMigrante.getInstance().subscribe(this.migrante, this.regiao);
	}
}
