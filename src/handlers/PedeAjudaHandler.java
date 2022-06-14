package handlers;

import catalogs.*;
import config.Configuration;
import notificacoes.Notificador;
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
	private static final String[] REGIOES = Configuration.getInstance().getStringArray("regioes");

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
	
	public void indicaNumFamilia(int num) {
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
	
	
	public Collection<Ajuda> ajudasDisponiveis(){
		Collection<Ajuda> res = ajudaCatalog.getValues();
		for (Ajuda ajuda : res) {
			if(ajuda.getMigrante() != null)
				res.remove(ajuda);
			Alojamento alojamento = (Alojamento) ajuda;
			if(alojamento.getRegiao() != null && (alojamento.getRegiao() != regiao || alojamento.getCapacity() < migrante.getFamilia().length))
				res.remove(ajuda);
		}
		//res.sort()
		//TODO
		return res;
	}
	
	
	public void indicaAjuda(Ajuda ajuda) {
		ajuda.assignMigrante(migrante);
	}
	
	public void ativarNotificacao() {
		Notificador.getInstance().subscribe(this.migrante, this.regiao);
	}
}
