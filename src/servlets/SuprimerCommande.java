package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommandeDao;
import dao.LigneCommandeDao;

/**
 * Servlet implementation class SuprimerCommande
 */
public class SuprimerCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuprimerCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));

        CommandeDao dao = new CommandeDao();

        LigneCommandeDao ldao=new LigneCommandeDao();
        ldao.remove(id);

        if(dao.remove(id))
        {
            response.sendRedirect("Admin/CommandeListe.jsp?add=success");
        }else
        {
            response.sendRedirect("Admin/CommandeListe.jsp?add=fail");
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
