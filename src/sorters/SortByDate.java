package sorters;

import java.util.Arrays;
import java.util.Collection;

import ajudas.Ajuda;

public class SortByDate implements Sorter {

	@Override
	public void sort(Collection<Ajuda> ajudas) {
		Ajuda[] ajudasArray = (Ajuda[]) ajudas.toArray();
		for (int i = 0; i < ajudasArray.length; i++) {
			for (int j = i; j < ajudasArray.length; j++) {
				if(ajudasArray[j].getId() < ajudasArray[j].getId())
					swap(ajudasArray, i, j);
			}
		}
		ajudas = Arrays.asList(ajudasArray);
	}
	
	private void swap(Object[] array, int a, int b) {
		Object buffer = array[b];
		array[b] = array[a];
		array[a] = buffer;
	}
}
