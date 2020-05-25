package controller;

import java.util.ArrayList;
import java.util.List;

import model.Adresa;
import model.Kontakt;
import model.User;
import servis.HibernateService;


public class GlavnaKlasa {

	public static void main(String[] args) {
		
		HibernateService service = new HibernateService();
		
		String userName = "nenad";
		String password = "nenad123";
		String ponovljeniPassword = "nenad123";
		String description = "neki opis";
		
		String drzava = "Srbija";
		String grad = "Beograd";
		String ulica = "Srpskih vladara";
		int postanskiBroj = 11000;
		
		List<Kontakt> kontakti = new ArrayList<Kontakt>();
	
			
		boolean proveriPass = service.proveriPassworde(password, ponovljeniPassword);
		
		if(proveriPass) {
			kontakti = service.setKontakte();
			Adresa adresa = service.setAdresa(drzava,grad,ulica,postanskiBroj);
			User user = service.setUser(userName, password, description,adresa,kontakti);
			service.saveUser(user);
		}
		
		int id = 1;
		User user = service.getUserFromDB(id);
		
		System.out.println("User:" + user.getUserName());
		System.out.println("Ulica:" + user.getAdresa().getUlica());
		System.out.println("Fiksni:" + user.getKontakti().get(0).getFiksniTelefon());
		

	
	

		

	}

}
