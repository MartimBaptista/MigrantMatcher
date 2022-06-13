package Catalogs;

import java.util.Iterator;

public interface CatalogInterface<E> {
	public void set(String key, E value);

	public E get(String key);

	public Iterator<E> getIterator();
}