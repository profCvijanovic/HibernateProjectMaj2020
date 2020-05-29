package dao.hibernate;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Prodavnica;
import model.Proizvod;
import model.Proizvodjac;
import model.Racun;
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

	public void saveProizvodjac(Proizvodjac proizvodjac) {
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(proizvodjac);
			sesija.getTransaction().commit();
			System.out.println("Proizvodjac snimljen u bazu");
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Proizvodjac nije snimljen u bazu");
		}finally {
			sesija.close();
		}		
		
	}

	public void saveProizvod(Proizvod proizvod) {
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(proizvod);
			sesija.getTransaction().commit();
			System.out.println("Proizvod snimljen u bazu");
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Proizvod nije snimljen u bazu");
		}finally {
			sesija.close();
		}	
		
	}

	public void saveRacun(Racun racun) {
		
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(racun);
			sesija.getTransaction().commit();
			System.out.println("Racun snimljen u bazu");
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Racun nije snimljen u bazu");
		}finally {
			sesija.close();
		}
		
	}

	public void saveProdavnica(Prodavnica prodavnica) {
		Session sesija = sf.openSession();
		sesija.beginTransaction();
		try {
			sesija.save(prodavnica);
			sesija.getTransaction().commit();
			System.out.println("Prodavnica snimljena u bazu");
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			System.out.println("Prodavnica nije snimljena u bazu");
		}finally {
			sesija.close();
		}
		
	}
	

}
