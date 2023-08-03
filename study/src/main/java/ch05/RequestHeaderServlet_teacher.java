package ch05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rhs")
public class RequestHeaderServlet_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String htmlTemplate = """
			<!DOCTYPE html>
			<html>
			<head><title>RequestHeader</title></head>
			<body>
			<h1>:result:</h1>
			</body>
			</html>
			""";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.sendRedirect("http://www.naver.com");
//		response.sendRedirect("/jwbook/ex/canRideRollerCoaster.html");
//		StringBuilder sb = new StringBuilder();
//		Enumeration<String> headerNames = request.getHeaderNames();
//		while (headerNames.hasMoreElements()) {
//			String headerName = headerNames.nextElement();
//			String headerValue = request.getHeader(headerName);
//			sb.append(headerName);
//			sb.append(": ");
//			sb.append(headerValue);
//			sb.append("<br>");
//
//		}
		request.setAttribute("username", "홍길동");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/jwbook/ex/canRideRollerCoaster.html");
//
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		String html = htmlTemplate.replace(":result:", sb.toString());
//		out.println(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
