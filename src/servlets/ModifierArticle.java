package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import Beans.Article;

/**
 * Servlet implementation class ModifierArticle
 */
public class ModifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String img = request.getParameter("urlImage");
        String desc = request.getParameter("desc");

        int id = Integer.parseInt(request.getParameter("id"));
        
        Article ar = new Article(id, libelle, desc, prix, img, quantite);
        ArticleDao dao = new ArticleDao();
        
        if(dao.update(ar))
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
