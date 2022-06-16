package tests;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ajudas.*;
import catalogs.AjudaCatalog;
import catalogs.VoluntarioCatalog;
import config.Configuration;
import sms.PidgeonSMSAdapter;
import sms.TelegramSMSAdapter;
import users.Voluntario;

class UseCase1 {

	@Test
	void test() {
		String[] numerosAloj = {"939491806", "923456295", "919457143"};
		int[] tamanhosAloj = {1,3,4};
		String[] regioesAloj = {"Lisboa", "Lisboa", "Porto"};
		
		String[] numerosItem = {"939221811", "919293911"};
		String[] descricaoItem = {"Alimentos", "Roupa"};
		
		//Redirecionar o output
		ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		
		//Criar os Voluntarios e Ajudas pelo Handler
		for (int i = 0; i < numerosAloj.length; i++) {
			TestingTools.setupVolAlojamento(numerosAloj[i], tamanhosAloj[i], regioesAloj[i]);
		}
		for (int i = 0; i < numerosItem.length; i++) {
			TestingTools.setupVolItem(numerosItem[i], descricaoItem[i]);
		}
		
		
		//Testar que os voluntarios foram guardados
		VoluntarioCatalog voluntarios = VoluntarioCatalog.getInstance();
		String[] numerosAmbos = Stream.concat(Arrays.stream(numerosAloj), Arrays.stream(numerosItem)).toArray(String[]::new);
		
		for (int i = 0; i < numerosAmbos.length; i++) {
			Voluntario voluntario = voluntarios.get(numerosAmbos[i]);
			Assertions.assertNotNull(voluntario);
			Assertions.assertEquals(numerosAmbos[i], voluntario.getTele());
		}
		
		//Testar que as ajudas foram guardadas
		
		AjudaCatalog ajudas = AjudaCatalog.getInstance();
		
		for (int i = 0; i < numerosAloj.length; i++) {
			//Geral
			Ajuda ajuda = ajudas.get(String.valueOf(i));
			Assertions.assertNotNull(ajuda);
			Assertions.assertEquals(i, ajuda.getId());
			Assertions.assertEquals(voluntarios.get(numerosAloj[i]), ajuda.getvoluntario());
			//Alojamento
			Assertions.assertTrue(ajuda instanceof Alojamento);
			Alojamento alojamento = (Alojamento) ajuda;
			Assertions.assertEquals(tamanhosAloj[i], alojamento.getCapacity());
			Assertions.assertEquals(regioesAloj[i], alojamento.getRegiao());
		}
		
		for (int i = 0; i < numerosItem.length; i++) {
			//Geral
			Ajuda ajuda = ajudas.get(String.valueOf(i + numerosAloj.length));
			Assertions.assertNotNull(ajuda);
			Assertions.assertEquals(i + numerosAloj.length, ajuda.getId());
			Assertions.assertEquals(voluntarios.get(numerosItem[i]), ajuda.getvoluntario());
			//Item
			Assertions.assertTrue(ajuda instanceof Item);
			Item item = (Item) ajuda;
			Assertions.assertEquals(descricaoItem[i], item.getDescricao());
		}
		
		//Testar envio de mensagem
		Scanner sc = new Scanner(out.toString());
		
		for	(int i = 0; i < numerosAmbos.length; i++) {
			String[] message = sc.nextLine().split(" ");
			//Caso Pidgeon:
			if(Configuration.getInstance().getInstanceOfClass("smsProvider", null) instanceof PidgeonSMSAdapter)
				Assertions.assertEquals("{SMSSender}", message[0]);
			//Caso Telegram:
			else if(Configuration.getInstance().getInstanceOfClass("smsProvider", null) instanceof TelegramSMSAdapter)
				Assertions.assertEquals("{TelegramSMSSender}", message[0]);
			//Numero:
			Assertions.assertEquals(numerosAmbos[i] + ":", message[1]);
		}
	}
}
