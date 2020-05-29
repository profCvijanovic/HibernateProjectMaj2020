package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="korisnik")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	@Column(name = "user_name")
	private String userName;
	@Column(nullable = false)
	private String password;
	@Column(name = "datum_pristupa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPristupa;
	@Lob
	private String description; // lob je large object
	@Transient
	private boolean daLiJeBioNaStranici;
	@Embedded
	private Adresa adresa;
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "kontakti_korisnika",
			   joinColumns = @JoinColumn(name = "user_id")
	)
	private List<Kontakt> kontakti = new ArrayList<Kontakt>();
	@ManyToMany(mappedBy = "korisnici" )
	private List<Prodavnica> pretplataNaProdavnice = new ArrayList<Prodavnica>();
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatumPristupa() {
		return datumPristupa;
	}
	public void setDatumPristupa(Date datumPristupa) {
		this.datumPristupa = datumPristupa;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDaLiJeBioNaStranici() {
		return daLiJeBioNaStranici;
	}
	public void setDaLiJeBioNaStranici(boolean daLiJeBioNaStranici) {
		this.daLiJeBioNaStranici = daLiJeBioNaStranici;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public List<Kontakt> getKontakti() {
		return kontakti;
	}
	public void setKontakti(List<Kontakt> kontakti) {
		this.kontakti = kontakti;
	}
	
	
		
}
