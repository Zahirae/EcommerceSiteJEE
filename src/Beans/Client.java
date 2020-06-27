package Beans;

public class Client {
	 private String email ;
	 private String password ;
	 private String nom ;
	 private String prenom ;
	 private int etat;

	 public Client(){}
	 public Client(String login, String mdp, String nom, String prenom){
	        this.email = login;
	        this.password = mdp;
	        this.nom = nom;
	        this.prenom = prenom;
	 }

	    
	  public Client(String login, String mdp, String nom, String prenom,int etat)
	    {
	        this.email = login;
	        this.password = mdp;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.etat=etat;
	    }	 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
