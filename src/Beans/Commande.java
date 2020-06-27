package Beans;

import java.util.Date;

public class Commande {
	private int idCommande ;
    private String login ;
    private int idArticle;
    private Date dateCmd ;
    private double prixTotale ;
    private int etat ;
    public Commande(){}
    public Commande(int idCommande, String login,int idArticle, Date dateCmd, double prixTotale, int etat)
    {
        this.idCommande = idCommande;
        this.login = login;
        this.idArticle = idArticle;
        this.dateCmd = dateCmd;
        this.prixTotale = prixTotale;
        this.etat = etat;
    }

    public Commande(String login,int idArticle, double prixTotale)
    {
        this.login = login;
        this.idArticle = idArticle;
        this.prixTotale = prixTotale;
    }
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	public double getPrixTotale() {
		return prixTotale;
	}
	public void setPrixTotale(double prixTotale) {
		this.prixTotale = prixTotale;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
}
