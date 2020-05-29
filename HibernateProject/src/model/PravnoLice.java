package model;

import javax.persistence.Entity;

@Entity
public class PravnoLice extends Kupac {
	
	private String pib;

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}
	
	

}
