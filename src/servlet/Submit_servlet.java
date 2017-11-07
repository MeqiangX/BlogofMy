package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.Bloger;
import service.Article_service;

/**
 * Servlet implementation class Submit_servlet
 */
@WebServlet("/Submit_servlet")
public class Submit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Article_service as = new Article_service();
		int u_id = ((Bloger)request.getSession().getAttribute("currentuser")).getId();
		int a_id = as.getMaxA_id(u_id)+1;
		
		String Content = "<h2 align='center'>" + request.getParameter("title") + "</h2>" + request.getParameter("content");
		//内容（详细信息只显示内容，所以把Title和content 都放啊在Content中）
		String describe = request.getParameter("content").substring(0, 20);
		//描述
		Date date = new Date(new java.util.Date().getTime());
		
		
		if (as.save(new Article(a_id,request.getParameter("title"),describe,Content,date,u_id))) {
			request.getRequestDispatcher("Controlor?flag=4").forward(request, response);
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
