package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Client;
import dao.ClientDao;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        
        ClientDao dao = new ClientDao();
        Client c = dao.findByAuthentification(login, mdp);
        
        if(c == null)
        {
        	if(login.matches("admin@gmail.com") && mdp.matches("admin")){
                response.sendRedirect("Admin/CompteListe.jsp");
           }else{
        	   String message = "Adress Email or Password Incorrect";
               request.setAttribute(message, message);
               RequestDispatcher view = request.getRequestDispatcher("login.jsp");
       		view.forward(request, response);
           }
        	           
        }else
        {
            request.getSession().setAttribute("client", c);
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
