package ordering;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private int id;
	private int customerId;
	private int bookId;
	private int saleprice;
	private Date orderDate;
	private Customer customer;
	private Book book;
	
	public Order() {}

	public Order(int id, int customerId, int bookId, int saleprice, String orderDate) {
		this.id = id;
		this.customerId = customerId;
		this.bookId = bookId;
		this.saleprice = saleprice;
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		try {
			this.orderDate = sdf.parse(orderDate);
		} catch (ParseException pe) {

		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
