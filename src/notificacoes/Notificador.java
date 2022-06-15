package notificacoes;


public interface Notificador<E,T> {
	
	public void subscribe(E notified, T notifier);
	
	public void unsubscribe(E notified, T notifier);
	
	public void unsubscribeALL(E notified);
	
	public void notificar(T notifier);
}
