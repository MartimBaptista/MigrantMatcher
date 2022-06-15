package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ajudas.Ajuda;
import catalogs.AjudaCatalog;
import catalogs.VoluntarioCatalog;
import handlers.RegistaAjudaHandler;
import users.Voluntario;

class UseCase1 {

	@Test
	void test() {
		//Rgistar Ajudas e Voluntarios
		RegistaAjudaHandler handler1 = new RegistaAjudaHandler();
		handler1.indicaVoluntario("939491806");
		handler1.indicaNumDePessoas(3);
		handler1.indicaRegiao("Lisboa");
		String codigo = handler1.enviarCodigo();
		handler1.confirmaCodigo(codigo);
		handler1.finalizarAjuda();
		
		//Testar que foram guardados
		
		VoluntarioCatalog voluntarios = VoluntarioCatalog.getInstance();
		AjudaCatalog ajudas = AjudaCatalog.getInstance();
		
		//Testar o Voluntario
		Assertions.assertNotNull(voluntarios.get("939491806"));
		Voluntario voluntario = voluntarios.get("939491806");
		Assertions.assertEquals("939491806", voluntario.getTele());
		
		//Testar a Ajuda
		Assertions.assertNotNull(ajudas.get(String.valueOf(0)));
		Ajuda ajuda = ajudas.get(String.valueOf(0));
		Assertions.assertEquals(0, ajuda.getId());
		Assertions.assertEquals(voluntario, ajuda.getvoluntario());
		
	}

}
