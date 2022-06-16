package sorters;

import ajudas.*;

public class SortByType implements Sorter {

	@Override
	public Ajuda[] sort(Ajuda[] ajudas) {
		Ajuda[] newAjudas = new Ajuda[ajudas.length];
		int alojamentoCounter = 0;
		int itemCounter = ajudas.length - 1;
		for (Ajuda ajuda : ajudas) {
			if(ajuda instanceof Alojamento) {
				newAjudas[alojamentoCounter] = ajuda;
				alojamentoCounter++;
			}
			else {
				newAjudas[itemCounter] = ajuda;
				itemCounter--;
			}
		}
		return newAjudas;
	}
}
