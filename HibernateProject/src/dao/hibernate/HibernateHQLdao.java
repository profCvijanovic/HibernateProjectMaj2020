package dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Kupac;

public class HibernateHQLdao {
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	// upisujem 10 kupaca u bazu
	public void ubaciDesetKupaca() {
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			for(int i = 1; i < 11; i++) {
				Kupac kupac= new Kupac();
				kupac.setImeKupca("Kupac" + i);
				kupac.setBalance(i*10);
				sesija.save(kupac);
			}
			sesija.getTransaction().commit();
		}catch (Exception e) {
			sesija.getTransaction().rollback();
		}finally {
			sesija.close();
		}
	}
	
	// preuzimam sve kupce iz baze
	public List<Kupac> preuzmiSveKupce(){
		
		List<Kupac> listaKupaca = new ArrayList<Kupac>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			// hql upit
			String pismo = "FROM Kupac";
			// prosledjujem pismo query objectu 
			Query query = sesija.createQuery(pismo);
			// koristim metodu getResultList() da bih preuzeo listu kupaca
			listaKupaca = query.getResultList();
			
			sesija.getTransaction().commit();
			return listaKupaca;
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}
			
	}
	
	
	
	
	public List<Kupac> kupciBalanceOdDo(String balanceOd, String balanceDo){
		
		List<Kupac> listaKupaca = new ArrayList<Kupac>();
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			// hql upit
			String pismo = "FROM Kupac WHERE balance >= :balanceOd AND balance <= :balanceDo ";
			// prosledjujem pismo query objectu 
			Query query = sesija.createQuery(pismo);
			//setovanje parametara
			query.setParameter("balanceOd", Double.parseDouble(balanceOd));
			query.setParameter("balanceDo", Double.parseDouble(balanceDo));
			// koristim metodu getResultList() da bih preuzeo listu kupaca
			listaKupaca = query.getResultList();
			
			sesija.getTransaction().commit();
			return listaKupaca;
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		}finally {
			sesija.close();
		}
			
	}
	
	
	
	public double vratiBalanceAkoZnasIme(String imeKupca) {
		
		double povratniBalance = 0;
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		try {
			// hql upit
			String pismo = "SELECT balance FROM Kupac WHERE imeKupca = :imeKupca";
			// prosledjujem pismo query objectu 
			Query query = sesija.createQuery(pismo);
			//setovanje parametara
			query.setParameter("imeKupca",imeKupca );
			// koristim metodu getResultList() da bih preuzeo listu kupaca
			//povratniBalance = (double)query.getResultList().get(0);
			povratniBalance = (double)query.getSingleResult();
			sesija.getTransaction().commit();
			return povratniBalance;
		}catch (Exception e) {
			sesija.getTransaction().rollback();
			return 0;
		}finally {
			sesija.close();
		}
		
		
	}
	
	
	
	
	
	
	
	

}
