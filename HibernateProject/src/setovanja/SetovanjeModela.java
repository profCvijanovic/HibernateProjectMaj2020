package setovanja;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Adresa;
import model.Kontakt;
import model.User;

public class SetovanjeModela {
	
	public User setUser(String userName,String password, String description, Adresa adresa, List<Kontakt> kontakti) {
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setDatumPristupa(new Date());
			user.setDescription(description);
			user.setAdresa(adresa);
			user.setKontakti(kontakti);
		return user;
	}
	
	public Adresa setAdresa(String drzava,String grad, String ulica, int postanskiBroj) {
		
		Adresa adresa  = new Adresa();
			adresa.setDrzava(drzava);
			adresa.setGrad(grad);
			adresa.setUlica(ulica);
			adresa.setPostanskiBroj(postanskiBroj);
		return adresa;
		
	}

	public List<Kontakt> setKontakte() {
		
		List<Kontakt> kontakti = new ArrayList<Kontakt>();
			
		Kontakt kontakt1 = new Kontakt();
			kontakt1.setFiksniTelefon("011222333");
			kontakt1.setInstagramName("kontakt1insta");
			kontakt1.setMailAdresa("kontakt1@gmail.com");
			kontakt1.setMobilniTelefon("06123456");
			kontakt1.setSkypeName("skypeKontakt1");
		
		Kontakt kontakt2 = new Kontakt();
			kontakt2.setFiksniTelefon("011333444");
			kontakt2.setInstagramName("kontakt2insta");
			kontakt2.setMailAdresa("kontakt2@gmail.com");
			kontakt2.setMobilniTelefon("06234567");
			kontakt2.setSkypeName("skypeKontakt2");
		
		kontakti.add(kontakt1);
		kontakti.add(kontakt2);
		
		return kontakti;
	}
	
	
	
	

}
