//package ch09;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang3.StringUtils;
//
//@WebServlet("/studentControl")
//public class StudentController_teacher extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	StudentDAO_teacher dao;
//
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		dao = new StudentDAO_teacher();
//	}
//
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String action = request.getParameter("action");
//		String view = "";
//
//		if (action == null) {
//			getServletContext().getRequestDispatcher("/studentControl?action=list").forward(request, response);
//		} else {
//			switch (action) {
//			case "list":
//				view = list(request, response);
//				break;
//			case "insert":
////				view = insert(request, response);
//				// 강사님 버전
//				insert(request, response);
//				break;
//			}
////			getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
//			// 강사님 버전
//			if (StringUtils.isNotEmpty(view)) {
//				getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
//			}
//		}
//	}
//
//	public String list(HttpServletRequest request, HttpServletResponse response) {
////		request.setAttribute("students", dao.getAll());
//		// 강사님 버전
//		List<Student> studentList = dao.getAll();
//		request.setAttribute("studentList", studentList);
//		return "studentInfo.jsp";
//	}
//
//	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
////		Student s = new Student();
////		try {
////			BeanUtils.populate(s, request.getParameterMap());
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		dao.insert(s);
////
////		try {
////			response.sendRedirect("/studentControl?action=list");
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		return list(request, response);
//
//		// 강사님 버전
//		Map map = request.getParameterMap();
//		Student student = new Student();
//		try {
//			BeanUtils.populate(student, map);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//
//		dao.insert(student);
//
//		response.sendRedirect("/jwbook/studentControl?action=list");
//	}
//
//}
