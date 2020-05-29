package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Prodavnica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProdavnica;
	private String imeProdavnice;
	@ManyToMany
	private List<User> korisnici = new ArrayList<User>();
	
	public int getIdProdavnica() {
		return idProdavnica;
	}
	public void setIdProdavnica(int idProdavnica) {
		this.idProdavnica = idProdavnica;
	}
	public String getImeProdavnice() {
		return imeProdavnice;
	}
	public void setImeProdavnice(String imeProdavnice) {
		this.imeProdavnice = imeProdavnice;
	}
	public List<User> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(List<User> korisnici) {
		this.korisnici = korisnici;
	}
	
	

}
