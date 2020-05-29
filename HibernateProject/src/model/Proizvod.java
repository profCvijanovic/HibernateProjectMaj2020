package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Proizvod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProizvod;
	private String nazivProizvoda;
	private double cena;
	private int popust;
	@OneToOne
	private Proizvodjac proizvodjac;
	
	public int getIdProizvod() {
		return idProizvod;
	}
	public void setIdProizvod(int idProizvod) {
		this.idProizvod = idProizvod;
	}
	public String getNazivProizvoda() {
		return nazivProizvoda;
	}
	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getPopust() {
		return popust;
	}
	public void setPopust(int popust) {
		this.popust = popust;
	}
	public Proizvodjac getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(Proizvodjac proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	
	
	
	
	
}
