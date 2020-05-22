package servis;

import dao.hibernate.HibernateDAO;
import model.Adresa;
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
	public User setUser(String userName, String password, String description, Adresa adresa) {		
		return setovanje.setUser(userName, password, description, adresa);
	}


	public boolean saveUser(User user) {
		return dao.saveUser(user);
	}
	
	
	

}
