package validacija;

public class ValidacijaUnosa {
	
	public boolean proveriPassworde(String password,String ponovljeniPassword) {
		if(password.equals(ponovljeniPassword)) {
			System.out.println("Dobri su passwordi!");
			return true;
		}else {
			System.out.println("Lose si popunio pass!");
			return false;
		}
	}

}
