package Beans;

public class LigneCommande {
	private int idCommande ;
	private int idArticle ;
	private int qte;
	public int getIdCommande() {
		return idCommande;
	}
	 public LigneCommande(int idCommande, int idArticle, int nbr)
	    {
	        this.idCommande = idCommande;
	        this.idArticle = idArticle;
	        this.qte = nbr;
	    }
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
}
