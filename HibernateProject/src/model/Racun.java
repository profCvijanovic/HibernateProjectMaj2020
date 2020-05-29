package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Racun {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRacun;
	private String sifraRacuna;
	@OneToMany
	private List<Proizvod> kupljeniProizvodi = new ArrayList<Proizvod>();

	public int getIdRacun() {
		return idRacun;
	}

	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}

	public String getSifraRacuna() {
		return sifraRacuna;
	}

	public void setSifraRacuna(String sifraRacuna) {
		this.sifraRacuna = sifraRacuna;
	}

	public List<Proizvod> getKupljeniProizvodi() {
		return kupljeniProizvodi;
	}

	public void setKupljeniProizvodi(List<Proizvod> kupljeniProizvodi) {
		this.kupljeniProizvodi = kupljeniProizvodi;
	}
	
	
	
}
