package servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommandeDao;
import dao.LigneCommandeDao;
import Beans.Client;
import Beans.Commande;
import Beans.LigneCommande;


/**
 * Servlet implementation class CommandeServlet
 */
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = (Client) request.getSession().getAttribute("client");
		int idArticle = Integer.parseInt(request.getParameter("idArticle")) ;
        double prix = Double.parseDouble( request.getParameter("prix"));
        Commande commande = new Commande(client.getEmail(),idArticle,prix);
        CommandeDao cdao = new CommandeDao();
        if(cdao.add(commande)){
        	 response.sendRedirect("index.jsp");
        }
        
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
