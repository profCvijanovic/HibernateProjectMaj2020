package controller;

import java.util.ArrayList;
import java.util.List;

import model.Adresa;
import model.Kontakt;
import model.Prodavnica;
import model.Proizvod;
import model.Proizvodjac;
import model.Racun;
import model.User;
import servis.HibernateService;


public class GlavnaKlasa {

	public static void main(String[] args) {
		
		HibernateService service = new HibernateService();
		
		// podaci za usera
		String userName = "nenad";
		String password = "nenad123";
		String ponovljeniPassword = "nenad123";
		String description = "neki opis";
		
		// podaci za adresu
		String drzava = "Srbija";
		String grad = "Beograd";
		String ulica = "Srpskih vladara";
		int postanskiBroj = 11000;
		
		List<Kontakt> kontakti = new ArrayList<Kontakt>();
		
		// podaci za proizvodjaca
		String imeProizvodjaca = "Cerveceria";
		
		// podaci za proizvod1
		String nazivProizvoda = "Korona";
		double cena = 100;
		int popust = 10;
		
		// podaci za proizvod2
		String nazivProizvoda2 = "Fly";
		double cena2 = 200;
		int popust2 = 5;
		
		// podaci za racun
		String sifraRacuna = "CZ-99";
		List<Proizvod> kupljeniProizvodi = new ArrayList<Proizvod>();
		
		// podaci za prodavnicu
		String imeProdavnice = "mini";
		List<User> useri = new ArrayList<User>();
		
		// podaci za prodavnicu2
		String imeProdavnice2 = "noidea";
		List<User> useri2 = new ArrayList<User>();
		
		boolean proveriPass = service.proveriPassworde(password, ponovljeniPassword);
		
		if(proveriPass) {
			// kontakti
			kontakti = service.setKontakte();
			// adresa
			Adresa adresa = service.setAdresa(drzava,grad,ulica,postanskiBroj);
			// user
			User user = service.setUser(userName, password, description,adresa,kontakti);
			service.saveUser(user);
			// proizvodjac
			Proizvodjac proizvodjac = service.setProizvodjac(imeProizvodjaca);
			service.saveProizvodjac(proizvodjac);
			// proizvod
			Proizvod proizvod = service.setProizvod(nazivProizvoda, cena, popust, proizvodjac);
			Proizvod proizvod2 = service.setProizvod(nazivProizvoda2, cena2, popust2, proizvodjac);
			service.saveProizvod(proizvod);
			service.saveProizvod(proizvod2);
			// racun
			kupljeniProizvodi.add(proizvod);
			kupljeniProizvodi.add(proizvod2);
			Racun racun = service.setRacun(sifraRacuna,kupljeniProizvodi);
			service.saveRacun(racun);
			// prodavnica
			useri.add(user);
			useri2.add(user);
			Prodavnica prodavnica = service.setProdavnica(imeProdavnice,useri);
			Prodavnica prodavnica2 = service.setProdavnica(imeProdavnice2,useri2);
			service.saveProdavnica(prodavnica);
			service.saveProdavnica(prodavnica2);
		}
		
		int id = 1;
		User user = service.getUserFromDB(id);
		
		System.out.println("User:" + user.getUserName());
		System.out.println("Ulica:" + user.getAdresa().getUlica());
		System.out.println("Fiksni:" + user.getKontakti().get(0).getFiksniTelefon());
		

	
	

		

	}

}
