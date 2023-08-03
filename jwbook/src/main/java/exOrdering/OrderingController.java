package exOrdering;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "OrderingControl", urlPatterns = { "/orderingControl" })
public class OrderingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	OrderingService os;

	public OrderingController() {
		super();
		os = new OrderingService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = StringUtils.defaultIfEmpty(request.getParameter("action"), "orderings");
		String view = "";
		switch (action) {
//		case "books":
//			view = books(request, response);
//			break;
		case "customers":
			view = customers(request, response);
			break;
		case "orderings":
			view = orderings(request, response);
			break;
		case "customer":
			view = customer(request, response);
			break;
//		case "createBook":
//			createBook(request, response);
//			break;
//		case "createCustomer":
//			createCustomer(request, response);
//			break;
		case "createOrdering":
			createOrdering(request, response);
			break;
		case "updateBook":
			updateCustomer(request, response);
			break;
		case "updateCustomer":
			updateCustomer(request, response);
			break;
		case "updateOrdering":
			updateCustomer(request, response);
			break;
		case "deleteBook":
			deleteCustomer(request, response);
			break;
		case "deleteCustomer":
			deleteCustomer(request, response);
			break;
		case "deleteOrdering":
			deleteCustomer(request, response);
			break;
		}
		if (StringUtils.isNotEmpty(view)) {
			getServletContext().getRequestDispatcher("/exOrdering/" + view).forward(request, response);
		}
	}

//	public String books(HttpServletRequest request, HttpServletResponse response) {
//		List<Book> bookList = os.getBook();
//
//		request.setAttribute("bookList", bookList);
//
//		return "/books.jsp";
//	}
//
//	public void createBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Book b = new Book();
//		try {
//			BeanUtils.populate(b, request.getParameterMap());
//			os.addBook(b);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		response.sendRedirect("orderingControl?action=books");
//	}

	public String customers(HttpServletRequest request, HttpServletResponse response) {
		boolean hasOrdering = Boolean
				.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrdering"), "false"));
		List<Customer> customerList = os.getCustomer();

		request.setAttribute("hasOrdering", hasOrdering);
		request.setAttribute("customerList", customerList);

		return "/customers.jsp";
	}

	public String customer(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		Customer customer = os.getCustomerOrBlank(id);
		request.setAttribute("customer", customer);

		return "/customer.jsp";
	}

	public void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			if (customer.getId() == -1) {
				os.addCustomer(customer);
			} else {
				os.setCustomer(customer);
			}
			response.sendRedirect("orderingControl?action=customers");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));

		boolean hasOrdering = os.hasOrderingCustomer(id);

		if (hasOrdering) {
			response.sendRedirect("orderingControl?action=customers&hasOrdering=true");
		} else {
			os.removeCustomer(id);
			response.sendRedirect("orderingControl?action=customers");
		}
	}

//	public void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Customer c = new Customer();
//		try {
//			BeanUtils.populate(c, request.getParameterMap());
//			os.addCustomer(c);
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		response.sendRedirect("orderingControl?action=customer");
//	}

	public String orderings(HttpServletRequest request, HttpServletResponse response) {
		List<Book> bookList = os.getBook();
		List<Customer> customerList = os.getCustomer();
		List<Ordering> orderingList = os.getOrdering();
		request.setAttribute("bookList", bookList);
		request.setAttribute("customerList", customerList);
		request.setAttribute("orderingList", orderingList);
		return "/orderings.jsp";
	}

	public void createOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Ordering o = new Ordering();
		try {
			BeanUtils.populate(o, request.getParameterMap());
			os.addOrdering(o);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		response.sendRedirect("orderingControl?action=orderings");
	}

//	public void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Book b = new Book();
//		try {
//			BeanUtils.populate(b, request.getParameterMap());
//			if (b.getId() == -1) {
//				os.addBook(b);
//			} else {
//				os.setBook(b);
//			}
//			response.sendRedirect("orderingControl?action=books");
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void updateOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Ordering o = new Ordering();
//		try {
//			BeanUtils.populate(o, request.getParameterMap());
//			if (o.getId() == -1) {
//				os.addOrdering(o);
//			} else {
//				os.setOrdering(o);
//			}
//			response.sendRedirect("orderingControl?action=orderings");
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
//
//		boolean hasOrdering = os.hasOrderingBook(id);
//
//		if (hasOrdering) {
//			response.sendRedirect("orderingControl?action=books&hasOrdering=true");
//		} else {
//			os.removeBook(id);
//			response.sendRedirect("orderingControl?action=books");
//		}
//	}
//
//	public void deleteOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
//
//		boolean hasOrdering = os.hasOrderingOrdering(id);
//
//		if (hasOrdering) {
//			response.sendRedirect("orderingControl?action=orderings&hasOrdering=true");
//		} else {
//			os.removeOrdering(id);
//			response.sendRedirect("orderingControl?action=orderings");
//		}
//	}
}
