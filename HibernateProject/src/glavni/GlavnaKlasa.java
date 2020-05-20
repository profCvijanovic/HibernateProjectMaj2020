package glavni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class GlavnaKlasa {

	public static void main(String[] args) {
			
		User user = new User();
		user.setUserName("nenad");
		user.setPassword("nenad123");
	
		// napravili smo fabriku sesija, Session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// potrazujem sesiju iz fabrike
		Session sesija = factory.openSession();
			//ovde zapocinje transakcija
			sesija.beginTransaction();
		
			try {
				
				// insert u bazu
				sesija.persist(user);
				System.out.println("Uspesno je dodat user u bazu");
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
