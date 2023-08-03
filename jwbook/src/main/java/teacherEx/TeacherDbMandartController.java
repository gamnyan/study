package teacherEx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "Mandalaart", urlPatterns = { "/mandalaart" })
public class TeacherDbMandartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TeacherDbMandartDAO mandalaartDao;

	public TeacherDbMandartController() {
		super();
		mandalaartDao = new TeacherDbMandartDAO();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goal = StringUtils.defaultIfEmpty(request.getParameter("goal"), "");

		String firstGoal = mandalaartDao.getFirstGoal();
		List<String> secondGoals = mandalaartDao.getSecondGoals();
		List<String> firstList = new ArrayList<>();
		firstList.addAll(secondGoals);
		firstList.add(4, firstGoal);
		request.setAttribute("firstList", firstList);

		if (StringUtils.isNotEmpty(goal)) {
			int secondId = mandalaartDao.getSecondIdByName(goal);
			List<String> thirdGoals = mandalaartDao.getThirdGoalsBySecondId(secondId);
			List<String> secondList = new ArrayList<>();
			secondList.addAll(thirdGoals);
			firstList.add(4, goal);
			request.setAttribute("secondList", secondList);
		}

		getServletContext().getRequestDispatcher("/teacherEx/teacherDbMandart.jsp").forward(request, response);
	}

}
