package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "vrsta_kupca",
                      discriminatorType = DiscriminatorType.STRING)
public class Kupac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKupac;
	private double balance;
	
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
	
	
	
}
