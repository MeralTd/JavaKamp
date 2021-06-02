package loginRegister.entities.concretes;

import loginRegister.entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private String ad;
	private String soyad;
	private String eposta;
	private String parola;
	private boolean aktifMi;

	public User() {}

	public User(int id, String ad, String soyad, String eposta, String parola, boolean aktifMi) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.eposta = eposta;
		this.parola = parola;
		this.aktifMi = aktifMi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
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

	public boolean isAktifMi() {
		return aktifMi;
	}

	public void setAktifMi(boolean aktifMi) {
		this.aktifMi = aktifMi;
	}
	
	
}