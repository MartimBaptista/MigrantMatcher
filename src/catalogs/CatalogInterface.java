package catalogs;

import java.util.Collection;

public interface CatalogInterface<E> {
	public void put(String key, E value);

	public E get(String key);

	public Collection<E> getValues();
}
