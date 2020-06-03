package controller;

import java.util.List;

import model.Kupac;
import servis.HibernateService;

public class KontrolerKlasa {

	public static void main(String[] args) {
		
		
		HibernateService service = new HibernateService();
		
		//service.ubaciDesetKupaca();
		
		List<Kupac> sviKupciIzBaze = service.preuzmiSveKupce();
		System.out.println("Kupac*****Balance");
		if(sviKupciIzBaze != null) {
			for(Kupac k: sviKupciIzBaze) {
				System.out.println(k.getImeKupca() + " *** " + k.getBalance());
			}
		}
		
		System.out.println("Kupac +++ Balance");
		String balanceOd = "105";
		String balanceDo = "150";
		List<Kupac> kupciBalanceOdDo = service.kupciBalanceOdDo(balanceOd,balanceDo);
		if(kupciBalanceOdDo != null) {
			for(Kupac k: kupciBalanceOdDo) {
				System.out.println(k.getImeKupca() + " ++++ " + k.getBalance());
			}
		}
		
		String imeKupca = "Kupac6";
		
		double vraceniBalance = service.vratiBalanceAkoZnasIme(imeKupca);
		System.out.println("Kupac " + imeKupca + " ima balance " + vraceniBalance);
		
		
		

	}

}
