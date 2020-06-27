package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Article;
import Beans.Client;
import Beans.Commande;
import Beans.LigneCommande;
import dao.ArticleDao;
import dao.CommandeDao;
import dao.LigneCommandeDao;
import panier.Panier;
import panier.PanierLines;

/**
 * Servlet implementation class PanierServlet
 */
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleDao articleDao = new ArticleDao();
		CommandeDao commandeDao = new CommandeDao();
		PanierLines pl = new PanierLines();
		Client client =null;
		ArrayList<PanierLines> lignesPanier=new ArrayList<PanierLines>();
		Panier panier = new Panier();
		
		if(request.getSession().getAttribute("client")!=null){  
		  	 client = (Client) request.getSession().getAttribute("client");
		  	 Vector<Commande> commandes = commandeDao.findByLogin(client.getEmail());
		  	 if(commandes!=null){

				 for(Commande commande : commandes){	
					Article a = articleDao.findByID(commande.getIdArticle());
					int qte = commandeDao.calculQte(client.getEmail(),commande.getIdArticle());
					pl.setArticle(a);
					pl.setQuantite(qte);
					lignesPanier.add(pl);
				}
		  	 }
			
			 panier.setLignesPanier(lignesPanier);
			  
		}
		request.getSession().setAttribute("panier", panier);
        response.sendRedirect("Panier.jsp");
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
