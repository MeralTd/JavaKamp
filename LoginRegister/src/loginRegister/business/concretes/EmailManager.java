package loginRegister.business.concretes;

import loginRegister.business.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void send(String message, String email) {
		System.out.println(message+" Doðrulama mesajý "+email+"eposta adresine gönderildi.");
	}

}
