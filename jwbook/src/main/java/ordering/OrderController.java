package ordering;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/ocontrol")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService customerService;
	BookService bookService;
	OrderService orderService;

	public OrderController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		customerService = new CustomerService();
		bookService = new BookService();
		orderService = new OrderService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";

		if (action == null) {
			getServletContext().getRequestDispatcher("/ocontrol?action=orderList").forward(request, response);
		} else {
			switch (action) {
			case "customerList":
				view = customerList(request, response);
				break;
			case "bookList":
				view = bookList(request, response);
				break;
			case "orderList":
				view = orderList(request, response);
				break;
			case "customerInfo":
				view = customerInfo(request, response);
				break;
			case "bookInfo":
				view = bookInfo(request, response);
				break;
			case "addOrder":
				addOrder(request, response);
//				view = orderList(request, response);
				break;
			case "addCustomer":
				addCustomer(request, response);
//				view = customerList(request, response);
				break;
			case "removeCustomer":
				removeCustomer(request, response);
//				view = customerList(request, response);
				break;
			case "setCustomer":
				setCustomer(request, response);
//				view = customerList(request, response);
				break;
			case "addBook":
				addBook(request, response);
//				view = customerList(request, response);
				break;
			case "removeBook":
				removeBook(request, response);
//				view = customerList(request, response);
				break;
			case "setBook":
				setBook(request, response);
//				view = customerList(request, response);
				break;
			}
			if (StringUtils.isNotBlank(view)) {
				getServletContext().getRequestDispatcher("/ordering/" + view).forward(request, response);
			}
		}
	}

	private String orderList(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("books", bookService.findAll());
		request.setAttribute("orders", orderService.findAll());
		return "orderList.jsp";
	}

	private String customerList(HttpServletRequest request, HttpServletResponse response) {
//		boolean hasOrder = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrder"), "false"));
//		if (Boolean.TRUE.equals(request.getSession().getAttribute("hasOrder"))) {
//
//		} else {
//			request.getSession().setAttribute("hasOrder", false);
//		}
		if (request.getSession().getAttribute("hasOrder") == null) {
			request.getSession().setAttribute("hasOrder", false);
		}

		List<Customer> customerListt = customerService.find();

//		request.setAttribute("hasOrder", hasOrder);
		request.setAttribute("customerListt", customerListt);

		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("books", bookService.findAll());
		request.setAttribute("orders", orderService.findAll());
		return "customerList.jsp";
	}

	private String bookList(HttpServletRequest request, HttpServletResponse response) {
		if (request.getSession().getAttribute("hasOrder") == null) {
			request.getSession().setAttribute("hasOrder", false);
		}

		List<Customer> bookList = customerService.find();
		request.setAttribute("bookList", bookList);

		request.setAttribute("customers", customerService.findAll());
		request.setAttribute("books", bookService.findAll());
		request.setAttribute("orders", orderService.findAll());
		return "bookList.jsp";
	}

	private String customerInfo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("c", customerService.find(Integer.parseInt(request.getParameter("id"))));
		return "customerInfo.jsp";
	}

	private String bookInfo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("b", bookService.find(Integer.parseInt(request.getParameter("id"))));
		return "bookInfo.jsp";
	}

	private String addOrder(HttpServletRequest request, HttpServletResponse response) {
		try {
			Order order = new Order();
			BeanUtils.populate(order, request.getParameterMap());
			orderService.add(order);
			try {
				response.sendRedirect("ocontrol?action=orderList");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "orderList.jsp";
	}

	private String addCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			Customer customer = new Customer();
			BeanUtils.populate(customer, request.getParameterMap());
			if (customer.getId() == -1) {
				customerService.add(customer);
			} else {

			}
			try {
				response.sendRedirect("ocontrol?action=customerList");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "customerList.jsp";
	}

	private String removeCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));

		boolean hasOrder = false;
		for (Order order : orderService.find()) {
			if (order.getCustomerId() == id) {
				hasOrder = true;
				break;
			}
		}

		if (hasOrder) {
//			response.sendRedirect("ocontrol?action=customerList&hasOrder=true");
//			request.setAttribute("hasOrder", true);
			request.getSession().setAttribute("hasOrder", true);
			response.sendRedirect("ocontrol?action=customerList");
			return "customerList.jsp";
		} else {
			customerService.remove(id);
//			response.sendRedirect("ocontrol?action=customerList");
//			request.setAttribute("hasOrder", false);
			request.getSession().setAttribute("hasOrder", false);
			response.sendRedirect("ocontrol?action=customerList");
			return "customerList.jsp";
		}
	}

	private String setCustomer(HttpServletRequest request, HttpServletResponse response) {
//		//boolean hasOrder = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrder"), "false"));
//		//List<Customer> customerList = customerService.find();
//		Customer customer = new Customer();
//		BeanUtils.populate(customer, request.getParameterMap());
//		customerService.set(customer);
//		//request.setAttribute("hasOrder", hasOrder);
//		request.setAttribute("customers", customerService.findAll());
//
//		return "/customerList.jsp";

		try {
			Customer customer = new Customer();
			BeanUtils.populate(customer, request.getParameterMap());

			customerService.set(customer);
			request.setAttribute("customers", customerService.findAll());

			try {
				response.sendRedirect("ocontrol?action=customerList");

			} catch (IOException e) {
				e.printStackTrace();
			}
//			response.sendRedirect("ocontrol?action=customers");

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "customerList.jsp";
	}

	private String addBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());
			if (book.getId() == -1) {
				bookService.add(book);
			} else {

			}
			try {
				response.sendRedirect("ocontrol?action=bookList");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "customerList.jsp";
	}

	private String removeBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));

		boolean hasOrder = false;
		for (Order order : orderService.find()) {
			if (order.getCustomerId() == id) {
				hasOrder = true;
				break;
			}
		}

		if (hasOrder) {
			request.getSession().setAttribute("hasOrder", true);
			response.sendRedirect("ocontrol?action=bookList");
			return "bookList.jsp";
		} else {
			customerService.remove(id);
			request.getSession().setAttribute("hasOrder", false);
			response.sendRedirect("ocontrol?action=bookList");
			return "bookList.jsp";
		}
	}

	private String setBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			Book book = new Book();
			BeanUtils.populate(book, request.getParameterMap());

			bookService.set(book);
			request.setAttribute("books", bookService.findAll());

			try {
				response.sendRedirect("ocontrol?action=bookList");

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return "bookList.jsp";
	}
}
