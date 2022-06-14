package sms;

public interface SMSProvider {
	public void sendSMS(String tele, String message);
}
