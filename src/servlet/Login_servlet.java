package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bloger;
import bean.User;
import service.Bloger_service;
import service.User_service;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name = request.getParameter("username");
		String password = request.getParameter("password");
	    
		User  user = new User(user_name,password);
		User_service us = new User_service();
		
		if (us.Login(user)) {
			Bloger_service bs = new Bloger_service();
			Bloger bloger = bs.getByName(user.getUser_name());
			
			request.getSession().setAttribute("currentuser", bloger);
			request.getSession().setMaxInactiveInterval(30*60);
			//将登陆的用户bean存放在sessionzhong 
			
			request.setAttribute("tag", 1);
		  request.getRequestDispatcher("/manager/page/manage.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("/index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
