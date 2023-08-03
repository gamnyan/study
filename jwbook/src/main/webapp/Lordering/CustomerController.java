package p0718;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/custcontrol")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService service;
	BookService bookservice;
	OrderService orderservice;

	public CustomerController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new CustomerService();
		bookservice = new BookService();
		orderservice = new OrderService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/custcontrol?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list":
				view = list(request, response);
				break;
			case "info":
				view = info(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/p0718/" + view).forward(request, response);
		}
	}

	private String addOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			Order ordering = new Order();
			BeanUtils.populate(ordering, request.getParameterMap());
			orderservice.add(ordering);
			// response.sendRedirect("madang?action=orderings");

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "customer_List.jsp";
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("c", service.find(request.getParameter("id")));
		request.setAttribute("b", service.find(request.getParameter("id")));
		return "customerInfo.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("customers", service.findAll());
		request.setAttribute("books", bookservice.findAll());
		request.setAttribute("orders", orderservice.findAll());
		return "customerList.jsp";
	}

}
