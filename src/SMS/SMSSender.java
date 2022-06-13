package SMS;

public class SMSSender {
	public void sendSMS(String tele, String message) {
		new PidgeonSMSAdapter().sendSMS(tele, message);
		//OR
		new TelegramSMSAdapter().sendSMS(tele, message);
		//TODO Implement the config as to pick one of the 2 adapters
	}
}
