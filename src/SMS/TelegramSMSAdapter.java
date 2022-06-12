package SMS;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

public class TelegramSMSAdapter implements SMSSender {

	@Override
	public void sendSMS(String tele, String message) {
		new PidgeonSMSSender().send(tele, message);
	}
}
