package controlor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlor
 */
@WebServlet("/Controlor")
public class Controlor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag = Integer.parseInt(request.getParameter("flag"));
		int tag;
		if (flag == 1) {
			tag = 1;
			request.setAttribute("tag", tag);
			request.getRequestDispatcher("/manager/page/manage.jsp").forward(request,response);
		}else if (flag == 2) {
			tag = 2;
			
			request.setAttribute("tag", tag);
			request.getRequestDispatcher("/manager/page/manage.jsp").forward(request,response);
		}else if (flag == 3) {
			
			request.getRequestDispatcher("Allbloguser?currentpage=1").forward(request,response);
		}else if (flag == 4) {
			request.getRequestDispatcher("Article_servlet?currentpage2=1").forward(request, response);
		}else
			tag = 5;
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
