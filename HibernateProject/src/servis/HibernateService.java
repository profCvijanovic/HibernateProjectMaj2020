package servis;

import java.util.List;

import dao.hibernate.HibernateDAO;
import model.Adresa;
import model.FizickoLice;
import model.Kontakt;
import model.Kupac;
import model.PravnoLice;
import model.Prodavnica;
import model.Proizvod;
import model.Proizvodjac;
import model.Racun;
import model.User;
import setovanja.SetovanjeModela;
import validacija.ValidacijaUnosa;

public class HibernateService {
	
	HibernateDAO dao = new HibernateDAO();
	SetovanjeModela setovanje = new SetovanjeModela();
	ValidacijaUnosa validacija = new ValidacijaUnosa();
	
	public boolean proveriPassworde(String password, String ponovljeniPassword) {	
		return validacija.proveriPassworde(password, ponovljeniPassword);
	}
	public User setUser(String userName, String password, String description, Adresa adresa, List<Kontakt> kontakti) {		
		return setovanje.setUser(userName, password, description, adresa, kontakti);
	}

	public boolean saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public Adresa setAdresa(String drzava, String grad, String ulica, int postanskiBroj) {
		return setovanje.setAdresa(drzava, grad, ulica, postanskiBroj);
	}
	public List<Kontakt> setKontakte() {
		return setovanje.setKontakte();
	}
	public User getUserFromDB(int id) {
		return dao.getUserFromDB(id);
	}
	public Proizvodjac setProizvodjac(String imeProizvodjaca) {
		return setovanje.setProizvodjac(imeProizvodjaca);
	}
	public void saveProizvodjac(Proizvodjac proizvodjac) {
		dao.saveProizvodjac(proizvodjac);
	}
	public Proizvod setProizvod(String nazivProizvoda, double cena, int popust, Proizvodjac proizvodjac) {
		return setovanje.setProizvod(nazivProizvoda,cena,popust, proizvodjac);
	}
	public void saveProizvod(Proizvod proizvod) {
		dao.saveProizvod(proizvod);
	}
	public Racun setRacun(String sifraRacuna, List<Proizvod> kupljeniProizvodi) {
		return setovanje.setRacun(sifraRacuna,kupljeniProizvodi);
	}
	public void saveRacun(Racun racun) {
		dao.saveRacun(racun);
		
	}
	public Prodavnica setProdavnica(String imeProdavnice, List<User> useri) {
		return setovanje.setProdavnica(imeProdavnice,useri);
	}
	public void saveProdavnica(Prodavnica prodavnica) {
		dao.saveProdavnica(prodavnica);
	}
	public Kupac setKupac(double balance) {
		return setovanje.setKupac(balance);
	}
	public void saveKupac(Kupac kupac) {
		dao.saveKupac(kupac);	
	}
	public FizickoLice setFizickoLice(double balanceFizicko, String jmbg) {
		return setovanje.setFizickoLice(balanceFizicko,jmbg);
	}
	public void saveFizickoLice(FizickoLice fizickoLice) {
		dao.saveFizickoLice(fizickoLice);
		
	}
	public PravnoLice setPravnoLice(double balancePravno, String pib) {
		return setovanje.setPravnoLice(balancePravno,pib);
	}
	public void savePravnoLice(PravnoLice pravnoLice) {
		dao.savePravnoLice(pravnoLice);		
	}
	
	
	

}
