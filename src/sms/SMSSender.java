package sms;

import config.Configuration;

public class SMSSender {
	private static SMSSender instance;
	private SMSAdapter provider;

	private SMSSender() {
		provider = Configuration.getInstance().getInstanceOfClass("smsProvider", new PidgeonSMSAdapter());
	}

	public static SMSSender getInstance() {
		if (instance == null) {
			return new SMSSender();
		} else {
			return instance;
		}
	}

	public void sendSMS(String tele, String message) {
		provider.sendSMS(tele, message);
	}
}
