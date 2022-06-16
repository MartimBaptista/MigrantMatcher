package sorters;

import java.util.Arrays;
import java.util.Collection;

import ajudas.*;

public class SortByType implements Sorter {

	@Override
	public void sort(Collection<Ajuda> ajudas) {
		Ajuda[] ajudasArray = new Ajuda[ajudas.size()];
		int alojamentoCounter = 0;
		int itemCounter = ajudasArray.length - 1;
		for (Ajuda ajuda : ajudas) {
			if(ajuda instanceof Alojamento) {
				ajudasArray[alojamentoCounter] = ajuda;
				alojamentoCounter++;
			}
			else {
				ajudasArray[itemCounter] = ajuda;
				itemCounter--;
			}
		}
		ajudas = Arrays.asList(ajudasArray);
	}
}
