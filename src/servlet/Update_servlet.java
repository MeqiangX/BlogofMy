package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bloger;
import service.Bloger_service;

/**
 * Servlet implementation class Update_servlet
 */
@WebServlet("/Update_servlet")
public class Update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		String Tel = request.getParameter("Tel");
		
		int id = Integer.parseInt(request.getParameter("blogerId"));
		
		String Mes = "";
		Bloger_service bs = new Bloger_service();
		Bloger bloger = bs.getById(id);
		
		bloger.setName(Name);
		bloger.setEmail(Email);
	    bloger.setTel(Tel);	
		boolean tag = bs.update(bloger);
		if (!tag) 
			Mes = "Update Failed";
		else
			Mes = "Update Success";
		request.setAttribute("mes", Mes);
			

		request.getRequestDispatcher("Controlor?flag=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
