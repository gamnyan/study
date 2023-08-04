package p3;

import java.util.List;

public class MadangService {
	MadangDAO dao;

	public MadangService() {
		dao = new MadangDAO();
	}

	public List<Book> getBook() {
		return dao.selectBook();
	}

	public Book getBook(int id) {
		return dao.selectBookById(id);
	}
	
	public Book getBookOrBlank(int id) {
		Book rtn = null;

		rtn = dao.selectBookById(id);

		if (rtn == null) {
			rtn = new Book();
			rtn.setId(-1);
			rtn.setTitle("");
			rtn.setPublisher("");
			rtn.setPrice(0);
		}
		return rtn;
	}
	
	public void addOrSetBook(Book book) {
		if(book.getId() == -1) {
			addBook(book);
		}else {
			setBook(book);
		}
	}
	
	public void addBook(Book book) {
		dao.insertBook(book);
	}
	
	public void setBook(Book book) {
		dao.updateBook(book);
	}
	
	public void removeBook(int id) throws HasOrderingException {
		boolean hasOrdering = hasOrderingCustomer(id);
		
		if(hasOrdering) {
			throw new HasOrderingException("Book has ordering");
		} else {
			dao.deleteCustomer(id);
		}		
	}

	public List<Customer> getCustomer() {
		return dao.selectCustomer();
	}

	public Customer getCustomerOrBlank(int id) {
		Customer rtn = null;

		rtn = dao.selectCustomerById(id);

		if (rtn == null) {
			rtn = new Customer();
			rtn.setId(-1);
			rtn.setName("");
			rtn.setAddress("");
			rtn.setPhone("");
		}
		return rtn;
	}
	
	public void addOrSetCustomer(Customer customer) {
		if(customer.getId() == -1) {
			addCustomer(customer);
		}else {
			setCustomer(customer);
		}
	}
	
	public void addCustomer(Customer customer) {
		dao.insertCustomer(customer);
	}
	
	public void setCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}
	
	public void removeCustomer(int id) throws HasOrderingException {
		boolean hasOrdering = hasOrderingCustomer(id);
		
		if(hasOrdering) {
			throw new HasOrderingException("Customer has ordering");
		} else {
			dao.deleteCustomer(id);
		}		
	}
	
	public List<Object[]> getOrdering(){
		return dao.selectOrdering();
	}
	
	public void addOrdering(Ordering ordering) {
		dao.insertOrdering(ordering);
	}
	
	boolean hasOrderingCustomer(int customerId) {
		boolean rtn = false;
		
		if(dao.selectCountByCustomerId(customerId) > 0) {
			rtn = true;
		}
		
		return rtn;
	}
	
	boolean hasOrderingBook(int bookId) {
		boolean rtn = false;
		
		if(dao.selectCountByBookId(bookId) > 0) {
			rtn = true;
		}
		
		return rtn;
	}
}
