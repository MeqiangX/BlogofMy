package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Page;
import service.Bloger_service;
import util.PageUtil;

/**
 * Servlet implementation class Allbloguser
 */
@WebServlet("/Allbloguser")
public class Allbloguser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allbloguser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int everycount = 5;
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
		
		Bloger_service bs = new Bloger_service();
		int count = bs.getCount();
		
		Page page = new PageUtil().getPage(currentpage, count, everycount);
		
		List list = bs.getByPage(page);
		
		request.setAttribute("Userlist", list);
		request.setAttribute("page", page);
		request.setAttribute("tag", 3);
		request.getRequestDispatcher("/manager/page/manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
