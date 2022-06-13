package SMS;

import com.telegramsms.TelegramSMSSender;

public class TelegramSMSAdapter implements SMSAdapterInterface {

	@Override
	public void sendSMS(String tele, String message) {
		TelegramSMSSender sender = new TelegramSMSSender();
		sender.setNumber(tele);
		sender.setText(message);
		sender.send();
	}
}
