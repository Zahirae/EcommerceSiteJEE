package Beans;


public class Article {
	 private int idArticle ;
	 private String libelle ;
	 private String description ;
	 private double prix ; 
	 private String image ;
	 private int stock ;

	    public Article()
	    {
	    }
	    public Article(String libelle, String desc, double prix, String img, int qte)
	    {
	        this.libelle = libelle;
	        this.description = desc;
	        this.prix = prix;
	        this.image = img;
	        this.stock = qte;
	    }

	 
	    public Article(int idArticle, String libelle, String desc, double prix, String img, int qte)
	    {
	        this.idArticle = idArticle;
	        this.libelle = libelle;
	        this.description = desc;
	        this.prix = prix;
	        this.image = img;
	        this.stock = qte;
	    }

		public int getIdArticle() {
			return idArticle;
		}

		public void setIdArticle(int idArticle) {
			this.idArticle = idArticle;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

}
