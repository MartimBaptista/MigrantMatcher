package sms;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

public class PidgeonSMSAdapter implements SMSAdapterInterface {

	@Override
	public void sendSMS(String tele, String message) {
		new PidgeonSMSSender().send(tele, message);
	}
}
