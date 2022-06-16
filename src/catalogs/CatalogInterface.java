package catalogs;


public interface CatalogInterface<E> {
	public void put(String key, E value);

	public E get(String key);

	public E[] getValues();
}
