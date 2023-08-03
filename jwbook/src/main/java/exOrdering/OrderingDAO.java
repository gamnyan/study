package exOrdering;

import java.sql.*;
import java.util.*;

public class OrderingDAO extends MadangDAO {

	public OrderingDAO() {
		super();
	}
	
	/* Book */

	public List<Book> selectBook() {
		List<Book> rtn = new ArrayList<>();

		String sql = "SELECT id, title, publisher, price FROM book";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setTitle(rs.getString("title"));
				b.setPublisher(rs.getString("publisher"));
				b.setPrice(rs.getInt("price"));

				rtn.add(b);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public Book selectBookById(int id) {
		Book rtn = null;
		
		String sql = "SELECT id, title, publisher, price FROM book WHERE id = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					rtn = new Book();
					rtn.setId(rs.getInt("id"));
					rtn.setTitle(rs.getString("title"));
					rtn.setPublisher(rs.getString("publisher"));
					rtn.setPrice(rs.getInt("price"));
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
//	public void insertBook(Book b) {
//		String sql = "INSERT INTO book (title, publisher, price) VALUES (?,?,?)";
//
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setString(1, b.getTitle());
//			ps.setString(2, b.getPublisher());
//			ps.setInt(3, b.getPrice());
//			ps.executeUpdate();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//	}
//
//	public void updateBook(Book b) {
//		String sql = "UPDATE book SET title = ?, publisher = ?, price = ? WHERE id = ?";
//		
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setString(1, b.getTitle());
//			ps.setString(2, b.getPublisher());
//			ps.setInt(3, b.getPrice());
//			ps.setInt(4, b.getId());
//			ps.executeUpdate();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//	}
//
//	public void deleteBook(int id) {
//		String sql = "DELETE FROM book WHERE id = ?";
//		
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//	}
	
	/* Customer */
	
	public List<Customer> selectCustomer() {
		List<Customer> rtn = new ArrayList<>();

		String sql = "SELECT id, name, address, phone FROM customer";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhone(rs.getString("phone"));

				rtn.add(c);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public Customer selectCustomerById(int id) {
		Customer rtn = null;

		String sql = "SELECT id, name, address, phone FROM customer WHERE id = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					rtn = new Customer();
					rtn.setId(rs.getInt("id"));
					rtn.setName(rs.getString("name"));
					rtn.setAddress(rs.getString("address"));
					rtn.setPhone(rs.getString("phone"));
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public void insertCustomer(Customer c) {
		String sql = "INSERT INTO customer (name, address, phone) VALUES (?,?,?)";

		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getPhone());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void updateCustomer(Customer c) {
		String sql = "UPDATE customer SET name = ?, address = ?, phone = ? WHERE id = ?";

		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getPhone());
			ps.setInt(4, c.getId());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM customer WHERE id = ?";

		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	/* Ordering */

	public List<Ordering> selectOrdering() {
		List<Ordering> rtn = new ArrayList<>();

		String sql = "SELECT o.id, c.name, b.title, o.sellingprice, o.orderingdate FROM ordering o LEFT OUTER JOIN customer c ON o.customerId = c.id LEFT OUTER JOIN book b ON o.bookId = b.id";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Ordering o = new Ordering();
				o.setId(rs.getInt("id"));
				Customer c = new Customer();
				c.setName(rs.getString("name"));
				o.setCustomer(c);
				Book b = new Book();
				b.setTitle(rs.getString("title"));
				o.setBook(b);
				o.setSellingPrice(rs.getInt("sellingPrice"));
				o.setOrderingDate(rs.getDate("orderingDate"));

				rtn.add(o);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public void insertOrdering(Ordering o) {
		String sql = "INSERT INTO ordering (customerId, bookId, sellingPrice, orderingDate) VALUES (?,?,?,?)";

		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, o.getCustomerId());
			ps.setInt(2, o.getBookId());
			ps.setInt(3, o.getSellingPrice());
			ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public int selectCountByCustomerId(int customerId) {
		int rtn = -1;
		
		String sql = "SELECT COUNT(*) FROM ordering WHERE customerId = ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, customerId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					rtn = rs.getInt(1);
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

//	public Ordering selectOrderingById(int id) {
//		Ordering rtn = null;
//
//		String sql = "SELECT id, customerId, bookId, sellingPrice, orderingDate FROM ordering WHERE id = ?";
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			try (ResultSet rs = ps.executeQuery()) {
//				if (rs.next()) {
//					rtn = new Ordering();
//					rtn.setId(rs.getInt("id"));
//					rtn.setCustomerId(rs.getInt("customerId"));
//					rtn.setBookId(rs.getInt("bookId"));
//					rtn.setSellingPrice(rs.getInt("sellingPrice"));
//					rtn.setOrderingDate(rs.getDate("orderingDate"));
//				}
//			}
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//		return rtn;
//	}
//	
//	public void updateOrdering(Ordering o) {
//		String sql = "UPDATE ordering SET customerId = ?, bookId = ?, sellingPrice = ?, orderingDate = ? WHERE id = ?";
//		
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, o.getCustomerId());
//			ps.setInt(2, o.getBookId());
//			ps.setInt(3, o.getSellingPrice());
//			ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
//			ps.setInt(5, o.getId());
//			ps.executeUpdate();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//	}
//	
//	public void deleteOrdering(int id) {
//		String sql = "DELETE FROM ordering WHERE id = ?";
//		
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			ps.executeUpdate();
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//	}
//	
//	public int selectCountByOrderingId(int id) {
//		int rtn = -1;
//		
//		String sql = "SELECT COUNT(*) FROM ordering WHERE id = ?";
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, id);
//			try (ResultSet rs = ps.executeQuery()) {
//				if (rs.next()) {
//					rtn = rs.getInt(1);
//				}
//			}
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//		return rtn;
//	}
//	
//	public int selectCountByBookId(int bookId) {
//		int rtn = -1;
//		
//		String sql = "SELECT COUNT(*) FROM ordering WHERE bookId = ?";
//		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setInt(1, bookId);
//			try (ResultSet rs = ps.executeQuery()) {
//				if (rs.next()) {
//					rtn = rs.getInt(1);
//				}
//			}
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//		}
//		return rtn;
//	}
}
