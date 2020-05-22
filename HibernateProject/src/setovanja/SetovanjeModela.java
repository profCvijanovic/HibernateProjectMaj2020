package setovanja;

import java.util.Date;

import model.Adresa;
import model.User;

public class SetovanjeModela {
	
	public User setUser(String userName,String password, String description, Adresa adresa) {
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setDatumPristupa(new Date());
			user.setDescription(description);
			user.setAdresa(adresa);
		return user;
	}

}
