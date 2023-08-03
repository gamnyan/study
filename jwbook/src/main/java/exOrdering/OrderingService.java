package exOrdering;

import java.util.List;

public class OrderingService {
	OrderingDAO dao;

	public OrderingService() {
		dao = new OrderingDAO();
	}
	
	/* Book */

	public List<Book> getBook() {
		return dao.selectBook();
	}

	public Book getBook(int id) {
		return dao.selectBookById(id);
	}

//	public Book getBookOrBlank(int id) {
//		Book rtn = null;
//		dao.selectBookById(id);
//
//		if (rtn == null) {
//			rtn = new Book();
//			rtn.setId(-1);
//			rtn.setTitle("");
//			rtn.setPublisher("");
//			rtn.setPrice(0);
//		}
//		return rtn;
//	}
//
//	public void addBook(Book b) {
//		dao.insertBook(b);
//	}
//
//	public void setBook(Book b) {
//		dao.updateBook(b);
//	}
//
//	public void removeBook(int id) {
//		dao.deleteBook(id);
//	}
	
	/* Customer */

	public List<Customer> getCustomer() {
		return dao.selectCustomer();
	}

	public Customer getCustomerOrBlank(int id) {
		Customer rtn = null;
		dao.selectCustomerById(id);

		if (rtn == null) {
			rtn = new Customer();
			rtn.setId(-1);
			rtn.setName("");
			rtn.setAddress("");
			rtn.setPhone("");
		}
		return rtn;
	}

	public void addCustomer(Customer c) {
		dao.insertCustomer(c);
	}

	public void setCustomer(Customer c) {
		dao.updateCustomer(c);
	}

	public void removeCustomer(int id) {
		dao.deleteCustomer(id);
	}
	
	/* Ordering */

	public List<Ordering> getOrdering() {
		return dao.selectOrdering();
	}

	public void addOrdering(Ordering o) {
		dao.insertOrdering(o);
	}

	boolean hasOrderingCustomer(int customerId) {
		boolean rtn = false;
		if (dao.selectCountByCustomerId(customerId) > 0) {
			rtn = true;
		}
		return rtn;
	}

//	boolean hasOrderingBook(int BookId) {
//		boolean rtn = false;
//		if (dao.selectCountByBookId(BookId) > 0) {
//			rtn = true;
//		}
//		return rtn;
//	}
//
//	public Ordering getOrderingOrBlank(int id) {
//		Ordering rtn = null;
//		dao.selectOrderingById(id);
//
//		if (rtn == null) {
//			rtn = new Ordering();
//			rtn.setId(-1);
//			rtn.setCustomerId(0);
//			rtn.setBookId(0);
//			rtn.setSellingPrice(0);
//			rtn.setOrderingDate(null);
//		}
//		return rtn;
//	}
//
//	public void setOrdering(Ordering o) {
//		dao.updateOrdering(o);
//	}
//
//	public void removeOrdering(int id) {
//		dao.deleteOrdering(id);
//	}
//	
//	boolean hasOrderingOrdering(int id) {
//		boolean rtn = false;
//		if (dao.selectCountByOrderingId(id) > 0) {
//			rtn = true;
//		}
//		return rtn;
//	}
}
