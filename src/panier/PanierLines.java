package panier;

import Beans.Article;

public class PanierLines {
	private Article article;
    private int quantite;

    public PanierLines(){}
    public PanierLines(Article art, int qte) 
    {    
            this.article = art;
            this.quantite = qte;
    }

    public Article getArticle() {
            return article;
    }

    public void setArticle(Article article) {
            this.article = article;
    }

    public int getQuantite() {
            return quantite;
    }

    public void setQuantite(int quantite) {
            this.quantite = quantite;
    }

    @Override
    public boolean equals(Object arg0) 
    {
            if(arg0 instanceof PanierLines){
                    if(this.article.equals(((PanierLines) arg0).article) && this.quantite ==((PanierLines) arg0).quantite)
                            return true;
                    else
                            return false;
            }else
                    return false;
    }

    @Override
    public int hashCode() 
    {
            return article.hashCode();
    }

    @Override
    public String toString() {
            return "LigneCommande : "+article.toString()+" | "+this.quantite;
    }
}
