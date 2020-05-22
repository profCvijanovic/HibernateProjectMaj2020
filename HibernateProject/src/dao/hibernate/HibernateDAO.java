package dao.hibernate;

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
	

}
