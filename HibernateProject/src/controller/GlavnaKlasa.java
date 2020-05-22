package controller;

import dao.hibernate.HibernateDAO;
import model.Adresa;
import model.User;
import servis.HibernateService;
import setovanja.SetovanjeModela;
import validacija.ValidacijaUnosa;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		HibernateService service = new HibernateService();
		
		String userName = "nenad";
		String password = "nenad123";
		String ponovljeniPassword = "nenad123";
		String description = "neki opis";
		
		Adresa adresa = new Adresa();
			adresa.setDrzava("Srbija");
			adresa.setGrad("Beograd");
			adresa.setUlica("Gandijeva");
			adresa.setPostanskiBroj(11070);
		boolean proveriPass = service.proveriPassworde(password, ponovljeniPassword);
		
		if(proveriPass) {
			User user = service.setUser(userName, password, description,adresa);
			service.saveUser(user);
		}

	
	

		

	}

}
