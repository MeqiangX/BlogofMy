package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.Bloger;
import bean.Page;
import bean.User;
import dao.ArticleDaoImpl;
import dao.BlogerDaoImpl;
import service.Article_service;
import util.PageUtil;

/**
 * Servlet implementation class Article_servlet
 */
@WebServlet("/Article_servlet")
public class Article_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bloger bloger = (Bloger)request.getSession().getAttribute("currentuser");
		Article_service as = new Article_service();
		int everycount = 4;
		int currentpage = Integer.parseInt(request.getParameter("currentpage2"));
		int allcount = as.getAll(bloger.getId());
		
		Page page = new PageUtil().getPage(currentpage, allcount, everycount);
		
		List<Article> list = as.getByPage(page, bloger.getId());
		
	    
	    request.setAttribute("artlist", list);
	    request.setAttribute("page2", page);
	    request.getRequestDispatcher("/manager/page/Article.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
