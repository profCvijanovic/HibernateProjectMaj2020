package glavni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class GlavnaKlasa {

	public static void main(String[] args) {
		
		//tranzijentni objekat
		User user = new User();

		// napravili smo fabriku sesija, Session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// potrazujem sesiju iz fabrike
		Session sesija = factory.openSession();
			//ovde zapocinje transakcija
			sesija.beginTransaction();
			try {
				//preuzimam usera ciji je id = 3;
				user = sesija.get(User.class, 3);
				// zatvorena uspesna transakcija
				sesija.getTransaction().commit();
			}catch (Exception e) {
				// zatvorena neuspesna transakcija
				sesija.getTransaction().rollback();
			}
		// zatvaram sesiju
		sesija.close();
		
		System.out.println(user.getUserName() + " " + user.getPassword());
		
		

	}

}
