package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import Beans.Article;

/**
 * Servlet implementation class AjouterArticle
 */
public class AjouterArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
        String desc = request.getParameter("desc");
        Double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite=Integer.parseInt(request.getParameter("quantite"));
        String img = request.getParameter("urlImage");
        
        Article act = new Article(-1, libelle, desc, prix,img, quantite);
        ArticleDao dao = new ArticleDao();
        
        if(dao.add(act))
        {
            response.sendRedirect("Admin/ProduitListe.jsp?add=success");
        }else
        {
            response.sendRedirect("Admin/ProduitListe.jsp?add=fail");
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
