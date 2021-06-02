package loginRegister.entities.Dto;

import loginRegister.entities.abstracts.Dto;

public class LoginModel implements Dto{
	private String eposta;
	private String parola;
	
	public LoginModel() {}

	public LoginModel(String eposta, String parola) {
		super();
		this.eposta = eposta;
		this.parola = parola;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
	
}
