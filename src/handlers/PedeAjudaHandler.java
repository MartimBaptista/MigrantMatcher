package handlers;

public class PedeAjudaHandler {
	private static PedeAjudaHandler instance;

	private PedeAjudaHandler() {
		//TODO
	}

	public static PedeAjudaHandler getInstance() {
		if (instance == null) {
			return new PedeAjudaHandler();
		} else {
			return instance;
		}
	}
}
