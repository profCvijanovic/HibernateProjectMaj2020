package glavni;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class GlavnaKlasa {

	public static void main(String[] args) {
		User user = new User();
		user.setUserName("nenad");
		user.setPassword("nenad123");
		user.setDatumPristupa(new Date());
		user.setDescription("Ovo polje mora biti jako veliko");
		user.setDaLiJeBioNaStranici(true);
		// napravili smo fabriku sesija, Session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// potrazujem sesiju iz fabrike
		Session sesija = factory.openSession();
			//ovde zapocinje transakcija
			sesija.beginTransaction();
			try {
					sesija.save(user);
				// zatvorena uspesna transakcija
				sesija.getTransaction().commit();
			}catch (Exception e) {
				// zatvorena neuspesna transakcija
				sesija.getTransaction().rollback();
			}
		// zatvaram sesiju
		sesija.close();
		

		

	}

}
