package sorters;

import ajudas.*;

public class SortByType implements Sorter {

	@Override
	public void sort(Ajuda[] ajudas) {
		int alojamentoCounter = 0;
		int itemCounter = ajudas.length - 1;
		for (Ajuda ajuda : ajudas) {
			if(ajuda instanceof Alojamento) {
				ajudas[alojamentoCounter] = ajuda;
				alojamentoCounter++;
			}
			else {
				ajudas[itemCounter] = ajuda;
				itemCounter--;
			}
		}
	}
}
