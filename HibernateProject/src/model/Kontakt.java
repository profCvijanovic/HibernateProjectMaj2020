package model;

import javax.persistence.Embeddable;

@Embeddable
public class Kontakt {
	
	private String mobilniTelefon;
	private String mailAdresa;
	private String fiksniTelefon;
	private String instagramName;
	private String skypeName;
	
	public String getMobilniTelefon() {
		return mobilniTelefon;
	}
	public void setMobilniTelefon(String mobilniTelefon) {
		this.mobilniTelefon = mobilniTelefon;
	}
	public String getMailAdresa() {
		return mailAdresa;
	}
	public void setMailAdresa(String mailAdresa) {
		this.mailAdresa = mailAdresa;
	}
	public String getFiksniTelefon() {
		return fiksniTelefon;
	}
	public void setFiksniTelefon(String fiksniTelefon) {
		this.fiksniTelefon = fiksniTelefon;
	}
	public String getInstagramName() {
		return instagramName;
	}
	public void setInstagramName(String instagramName) {
		this.instagramName = instagramName;
	}
	public String getSkypeName() {
		return skypeName;
	}
	public void setSkypeName(String skypeName) {
		this.skypeName = skypeName;
	}
	
}
