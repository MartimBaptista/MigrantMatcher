package sms;

import com.telegramsms.TelegramSMSSender;

public class TelegramSMSAdapter implements SMSAdapter {

	@Override
	public void sendSMS(String tele, String message) {
		TelegramSMSSender sender = new TelegramSMSSender();
		sender.setNumber(tele);
		sender.setText(message);
		sender.send();
	}
}
