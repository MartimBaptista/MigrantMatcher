package sorters;

import ajudas.Ajuda;

public class SortByDate implements Sorter {

	@Override
	public Ajuda[] sort(Ajuda[] ajudas) {
		for (int i = 0; i < ajudas.length; i++) {
			for (int j = i; j < ajudas.length; j++) {
				if(ajudas[j].getId() < ajudas[j].getId())
					swap(ajudas, i, j);
			}
		}
		return ajudas;
	}
	
	private void swap(Object[] array, int a, int b) {
		Object buffer = array[b];
		array[b] = array[a];
		array[a] = buffer;
	}
}
