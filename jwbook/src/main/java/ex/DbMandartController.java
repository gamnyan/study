package ex;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mandartControl")
public class DbMandartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DbMandartDAO dao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new DbMandartDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/mandartControl?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/ex/" + view).forward(request, response);
		}
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("dbMandarts", dao.getAll());
		return "dbMandartInfo.jsp";
	}

}
