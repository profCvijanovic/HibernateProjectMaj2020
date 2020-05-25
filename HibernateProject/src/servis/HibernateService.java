package servis;

import java.util.List;

import dao.hibernate.HibernateDAO;
import model.Adresa;
import model.Kontakt;
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
	
	
	

}
