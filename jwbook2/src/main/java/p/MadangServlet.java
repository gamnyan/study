package p;

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

@WebServlet(name = "Madang", urlPatterns = { "/madang" })
public class MadangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MadangService ms;

	public MadangServlet() {
		super();

		ms = new MadangService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = StringUtils.defaultIfEmpty(request.getParameter("action"), "orderings");
		String view = "";
		switch (action) {
		case "orderings":
			view = orderings(request, response);
			break;
		case "createOrdering":
			createOrdering(request, response);
			break;
		case "customers":
			view = customers(request, response);
			break;
		case "customer":
			view = customer(request, response);
			break;
		case "updateCustomer":
			updateCustomer(request, response);
			break;
		case "deleteCustomer":
			deleteCustomer(request, response);
			break;
		case "books":
			view = books(request, response);
			break;
		case "book":
			view = book(request, response);
			break;
		case "updateBook":
			updateBook(request, response);
			break;
		case "deleteBook":
			deleteBook(request, response);
			break;
		}

		if (StringUtils.isNotEmpty(view)) {
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
	}

	String books(HttpServletRequest request, HttpServletResponse response) {
		boolean hasOrdering = Boolean
				.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrdering"), "false"));
		List<Book> bookList = ms.getBook();
		
		request.setAttribute("hasOrdering", hasOrdering);
		request.setAttribute("bookList", bookList);
		
		return "/books.jsp";
	}
	
	String book(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		Book book = ms.getBookOrBlank(id);
		request.setAttribute("book", book);
		
		return "/book.jsp";
	}
	
	void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			/*
			 * if (customer.getId() == -1) { ms.addCustomer(customer); } else {
			 * ms.setCustomer(customer); }
			 */
			ms.addOrSetBook(book);
			response.sendRedirect("madang?action=books");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		try {
			ms.removeBook(id);
			response.sendRedirect("madang?action=books");
		} catch (HasOrderingException hoe) {
			response.sendRedirect("madang?action=books&hasOrdering=true");
		}
		
	}
	
	String customers(HttpServletRequest request, HttpServletResponse response) {
		boolean hasOrdering = Boolean
				.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrdering"), "false"));
		List<Customer> customerList = ms.getCustomer();

		request.setAttribute("hasOrdering", hasOrdering);
		request.setAttribute("customerList", customerList);

		return "/customers.jsp";
	}

	String customer(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		Customer customer = ms.getCustomerOrBlank(id);
		request.setAttribute("customer", customer);

		return "/customer.jsp";
	}

	void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
			/*
			 * if (customer.getId() == -1) { ms.addCustomer(customer); } else {
			 * ms.setCustomer(customer); }
			 */
			ms.addOrSetCustomer(customer);
			response.sendRedirect("madang?action=customers");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
		try {
			ms.removeCustomer(id);
			response.sendRedirect("madang?action=customers");
		} catch (HasOrderingException hoe) {
			response.sendRedirect("madang?action=customers&hasOrdering=true");
		}

	}

	String orderings(HttpServletRequest request, HttpServletResponse response) {
		List<Customer> customerList = ms.getCustomer();
		List<Book> bookList = ms.getBook();
		List<Object[]> orderingList = ms.getOrdering();

		request.setAttribute("customerList", customerList);
		request.setAttribute("bookList", bookList);
		request.setAttribute("orderingList", orderingList);

		return "/orderings.jsp";
	}

	void createOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Ordering ordering = new Ordering();
		try {
			BeanUtils.populate(ordering, request.getParameterMap());
			ms.addOrdering(ordering);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		response.sendRedirect("madang?action=orderings");
	}
}
