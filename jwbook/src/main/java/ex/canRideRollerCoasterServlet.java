package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/canRRC")
public class canRideRollerCoasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public canRideRollerCoasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int age = Integer.parseInt(request.getParameter("age"));
		int height = Integer.parseInt(request.getParameter("height"));
		String parent = request.getParameter("parent");
		String heartDisease = request.getParameter("heartDisease");

		String result = null;

		if (heartDisease.equals("2") && height >= 120) {
			if (age >= 6 || parent != null) {
				result = "가능";
			} else {
				result = "불가";
			}
		} else {
			result = "불가";
		}

		String htmlTemplate = """
				<html>
					<body>
						<h1>탑승 여부</h1>
						<hr>
						<h1>탑승: :result:</h1>
					</body>
				</html>
				""";
		String html = htmlTemplate.replace(":result:", result);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
