package dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.User;

public class HibernateDAO {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public boolean saveUser(User user) {		
		Session sesija = sf.openSession();
			sesija.beginTransaction();
			try {
				sesija.save(user);
				sesija.getTransaction().commit();
				return true;
			}catch (Exception e) {
				sesija.getTransaction().rollback();
				return false;
			}finally {
				sesija.close();
			}		
	}
	
	public User getUserFromDB(int id) {
		
		User user = new User();
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			user = sesija.get(User.class, id);
			// user.getKontakti().size(); 1. varijanta cheat, ucitavanje liste iz baze
			Hibernate.initialize(user.getKontakti());
			sesija.getTransaction().commit();
			return user;
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}	
		
	}
	

}
