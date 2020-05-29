package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proizvodjac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProizvodjac;
	private String imeProizvodjaca;
	
	public int getIdProizvodjac() {
		return idProizvodjac;
	}
	public void setIdProizvodjac(int idProizvodjac) {
		this.idProizvodjac = idProizvodjac;
	}
	public String getImeProizvodjaca() {
		return imeProizvodjaca;
	}
	public void setImeProizvodjaca(String imeProizvodjaca) {
		this.imeProizvodjaca = imeProizvodjaca;
	}
	
	

}
