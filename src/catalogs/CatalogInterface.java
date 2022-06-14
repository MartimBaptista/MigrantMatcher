package catalogs;

import java.util.Iterator;

public interface CatalogInterface<E> {
	public void put(String key, E value);

	public E get(String key);

	public Iterator<E> getIterator();
}
