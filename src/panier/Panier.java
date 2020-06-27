package panier;

import java.util.ArrayList;

public class Panier {
	  private ArrayList<PanierLines> lignesPanier;

	  public Panier(){
	        setLignesPanier(new ArrayList<PanierLines>());
	  }

	public ArrayList<PanierLines> getLignesPanier() {
		return lignesPanier;
	}

	public void setLignesPanier(ArrayList<PanierLines> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}

}
