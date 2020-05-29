package model;

import javax.persistence.Entity;

@Entity
public class FizickoLice extends Kupac {
	
	private String jmbg;

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	

}
