package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Kupac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKupac;
	private double balance;
	private String imeKupca;
	
	public int getIdKupac() {
		return idKupac;
	}
	public void setIdKupac(int idKupac) {
		this.idKupac = idKupac;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getImeKupca() {
		return imeKupca;
	}
	public void setImeKupca(String imeKupca) {
		this.imeKupca = imeKupca;
	}
	
	
	
}
