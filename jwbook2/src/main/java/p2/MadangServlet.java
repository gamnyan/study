package p2;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
	
	CustomerService customerService;
	BookService bookService;
	OrderingService orderingService;
       
    public MadangServlet() {
        super();
        
        customerService = new CustomerService();
        bookService = new BookService();
        orderingService = new OrderingService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String action = StringUtils.defaultIfEmpty(request.getParameter("action"), "orderings");
    	String view = "";
    	switch(action) {
    	case "apiCustomers":
    		apiCustomers(request, response);
    		break;
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
    	}
    	
    	if(StringUtils.isNotEmpty(view)) {
    		getServletContext().getRequestDispatcher(view).forward(request, response);
    	}
    }
    
    void apiCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	List<Customer> customerList = customerService.get();
    	List<String> jsonStringList = new ArrayList<>();
    	for(Customer customer : customerList) {
    		jsonStringList.add(customer.toJsonString());
    	}
    	String jsonArrayString = StringUtils.join(jsonStringList);
    	System.out.println(jsonArrayString);
    	response.setHeader("Content-Type", "application/json; charset=utf-8");
    	PrintWriter pw = response.getWriter();
    	pw.print(jsonArrayString);
    	pw.flush();
    	pw.close();
    }
    
    void apiCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	
    }
    
    String customer(HttpServletRequest request, HttpServletResponse response) {
    	int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
    	Customer customer = customerService.getOrBlank(id);
    	request.setAttribute("customer", customer);
    	
    	return "/customer.jsp";
    }
    
    String customers(HttpServletRequest request, HttpServletResponse response) {
    	boolean hasOrdering = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasOrdering"), "false"));
    	List<Customer> customerList = customerService.get();
    	
    	request.setAttribute("hasOrdering", hasOrdering);
    	request.setAttribute("customerList", customerList);
    	
    	return "/customers.jsp";
    }
    
    
    
    void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	Customer customer = new Customer();
    	try {
    		BeanUtils.populate(customer, request.getParameterMap());
    		customerService.addOrSet(customer);
    		response.sendRedirect("madang?action=customers");
    	} catch(IllegalAccessException | InvocationTargetException e) {
    		e.printStackTrace();
    	}
    }
    
    void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
    	try {
    		customerService.remove(id);
    		response.sendRedirect("madang?action=customers");
    	} catch(HasOrderingException hoe) {
    		response.sendRedirect("madang?action=customers&hasOrdering=true");
    	}
    }
    
    String orderings(HttpServletRequest request, HttpServletResponse response) {
    	List<Customer> customerList = customerService.get();
    	List<Book> bookList = bookService.get();
    	List<Object[]> orderingList = orderingService.get();
    	
    	request.setAttribute("customerList", customerList);
    	request.setAttribute("bookList", bookList);
    	request.setAttribute("orderingList", orderingList);
    	
    	return "/orderings.jsp";
    }
    
    void createOrdering(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	Ordering ordering = new Ordering();
    	try {
    		BeanUtils.populate(ordering, request.getParameterMap());
    		orderingService.add(ordering);
    	} catch(IllegalAccessException | InvocationTargetException e) {
    		e.printStackTrace();
    	}
    	response.sendRedirect("madang?action=orderings");
    }
}
