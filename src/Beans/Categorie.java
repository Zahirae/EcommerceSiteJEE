package Beans;

public class Categorie {
	private int idCategorie;
	private String categorieName;
	public Categorie(){}
	
	public Categorie(String cat){
		this.categorieName = cat;
	}
	public Categorie(int idCategorie, String cat){
		this.idCategorie = idCategorie;
		this.categorieName = cat;
	}
	public int getIdCat() {
		return idCategorie;
	}
	public void setIdCat(int idCat) {
		this.idCategorie = idCat;
	}
	public String getCategorieName() {
		return categorieName;
	}
	public void setCategorieName(String categorieName) {
		this.categorieName = categorieName;
	}
}
