package p;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class MadangDAO {
	protected DataSource dataSource;
	
	/*//sqls에 필요한 것들 QM 전단계임
	 * Properties sqls; */

	final static String QUERY_PATH = "/p/madang_sql.properties";
	final static Map<String, String> QM;
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new ExceptionInInitializerError(ioe);
		}
	}

	public MadangDAO() {
		/*
		 * //sqls에 필요한 것들 QM 전단계임
		 * spls = new Properties(); try {
		 * sqls.load((getClass().getResourceAsStream("/p/Madang_sql.properties")); }
		 * catch(IOException ioe) { ioe.printStackTrace() }
		 */
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

	public List<Book> selectBook() {
		/*
		 * List<Book> rtn = new ArrayList<>();
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectBook")); ResultSet rs = ps.executeQuery();)
		 * { while (rs.next()) { Book book = new Book(); book.setId(rs.getInt("id"));
		 * book.setTitle(rs.getString("title"));
		 * book.setPublisher(rs.getString("publisher"));
		 * book.setPrice(rs.getInt("price")); rtn.add(book); }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		/*
		 * // dbutils 적용 List<Book> rtn = new ArrayList<>(); List<Book> rtn = new
		 * ArrayList<>(); try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); ResultSetHandler<List<Book>> h = new
		 * BeanListHandler<>(Book.class); rtn = qr.query(c, QM.get("selectBook"), h);
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		List<Book> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Book>> h = new BeanListHandler<>(Book.class);
			rtn = qr.query(QM.get("selectBook"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public Book selectBookById(int id) {
		/*
		 * Book rtn = null;
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectBookById"));) { ps.setInt(1, id); try
		 * (ResultSet rs = ps.executeQuery();) { if (rs.next()) { Book book = new
		 * Book(); book.setId(rs.getInt("id")); book.setTitle(rs.getString("title"));
		 * book.setPublisher(rs.getString("publisher"));
		 * book.setPrice(rs.getInt("price")); } }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		/*
		 * // dbutils 적용 Book rtn = null;
		 * 
		 * try (Connection c = dataSource.getConnection()) { QueryRunner qr = new
		 * QueryRunner(); ResultSetHandler<Book> h = new BeanHandler<>(Book.class);
		 * Object[] p = { id }; rtn = qr.query(c, QM.get("selectBookById"), h, p); }
		 * catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		Book rtn = null;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Book> h = new BeanHandler<>(Book.class);
			Object[] p = { id };
			rtn = qr.query(QM.get("selectBookById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public void insertBook(Book book) {

		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("insertBook"))) { ps.setString(1, book.getTitle());
		 * ps.setString(2, book.getPublisher()); ps.setInt(3, book.getPrice());
		 * ps.executeUpdate(); } catch (SQLException sqle) { sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { book.getTitle(), book.getPublisher(),
		 * book.getPrice() }; qr.execute(c, QM.get("insertBook"), p); } catch
		 * (SQLException sqle) { sqle.printStackTrace(); }
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { book.getTitle(), book.getPublisher(), book.getPrice() };
			qr.execute(QM.get("insertBook"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	public void updateBook(Book book) {

		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("updateBook"))) { ps.setString(1, book.getTitle());
		 * ps.setString(2, book.getPublisher()); ps.setInt(3, book.getPrice());
		 * ps.setInt(4, book.getId()); ps.executeUpdate(); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { book.getTitle(), book.getPublisher(),
		 * book.getPrice() }; qr.execute(c, QM.get("updateBook"), p); } catch
		 * (SQLException sqle) { sqle.printStackTrace(); }
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { book.getTitle(), book.getPublisher(), book.getPrice() };
			qr.execute(QM.get("updateBook"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void deleteBook(int id) throws HasOrderingException {

		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("deleteBook"))) { ps.setInt(1, id);
		 * ps.executeUpdate(); } catch (SQLException sqle) { sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { id }; qr.execute(c,
		 * QM.get("deleteBook"), p); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { id };
			qr.execute(QM.get("deleteBook"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public List<Customer> selectCustomer() {
		/*
		 * List<Customer> rtn = new ArrayList<>();
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectCustomer")); ResultSet rs =
		 * ps.executeQuery();) { while (rs.next()) { Customer customer = new Customer();
		 * customer.setId(rs.getInt("id")); customer.setName(rs.getString("name"));
		 * customer.setAddress(rs.getString("address"));
		 * customer.setPhone(rs.getString("phone")); rtn.add(customer); }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dbutils 적용
		/*
		 * List<Customer> rtn = new ArrayList<>();
		 * 
		 * try (Connection c = dataSource.getConnection()) { QueryRunner qr = new
		 * QueryRunner(); ResultSetHandler<List<Customer>> h = new
		 * BeanListHandler<>(Customer.class); rtn = qr.query(c,
		 * QM.get("selectCustomer"), h);
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		List<Customer> rtn = new ArrayList<>();

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Customer>> h = new BeanListHandler<>(Customer.class);
			rtn = qr.query(QM.get("selectCustomer"), h);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public Customer selectCustomerById(int id) {
		/*
		 * Customer rtn = null;
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectCustomerById"));) {
		 * 
		 * ps.setInt(1, id); try (ResultSet rs = ps.executeQuery();) { if (rs.next()) {
		 * rtn = new Customer(); rtn.setId(rs.getInt("id"));
		 * rtn.setName(rs.getString("name")); rtn.setAddress(rs.getString("address"));
		 * rtn.setPhone(rs.getString("phone")); } }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		/*
		 * // dbutils 적용 Customer rtn = null;
		 * 
		 * try (Connection c = dataSource.getConnection()) { QueryRunner qr = new
		 * QueryRunner(); ResultSetHandler<Customer> h = new
		 * BeanHandler<>(Customer.class); Object[] p = { id }; rtn = qr.query(c,
		 * QM.get("selectCustomerById"), h, p); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		Customer rtn = null;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Customer> h = new BeanHandler<>(Customer.class);
			Object[] p = { id };
			rtn = qr.query(QM.get("selectCustomerById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public void insertCustomer(Customer customer) {
		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("insertCustomer"))) { ps.setString(1,
		 * customer.getName()); ps.setString(2, customer.getAddress()); ps.setString(3,
		 * customer.getPhone()); ps.executeUpdate(); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { customer.getName(),
		 * customer.getAddress(), customer.getPhone() }; qr.execute(c,
		 * QM.get("insertCustomer"), p); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { customer.getName(), customer.getAddress(), customer.getPhone() };
			qr.execute(QM.get("insertCustomer"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void updateCustomer(Customer customer) {
		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("updateCustomer"))) { ps.setString(1,
		 * customer.getName()); ps.setString(2, customer.getAddress()); ps.setString(3,
		 * customer.getPhone()); ps.setInt(4, customer.getId()); ps.executeUpdate(); }
		 * catch (SQLException sqle) { sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { customer.getName(),
		 * customer.getAddress(), customer.getPhone(), customer.getId() }; qr.execute(c,
		 * QM.get("updateCustomer"), p); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		// dataSource를 아예 QueryRunner안에 넣어버려서 코드 줄여버리기
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId() };
			qr.execute(QM.get("updateCustomer"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public void deleteCustomer(int id) throws HasOrderingException {
		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("deleteCustomer"))) { ps.setInt(1, id);
		 * ps.executeUpdate(); } catch (SQLException sqle) { sqle.printStackTrace(); }
		 */

		/*
		 * // dbutils 적용 try (Connection c = dataSource.getConnection()) { QueryRunner
		 * qr = new QueryRunner(); Object[] p = { id }; qr.execute(c,
		 * QM.get("deleteCustomer"), p); } catch (SQLException sqle) {
		 * sqle.printStackTrace(); }
		 */

		// dbutils 적용
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = { id };
			qr.execute(QM.get("deleteCustomer"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public List<Object[]> selectOrdering() {

		/*
		 * List<Ordering> rtn = new ArrayList<>(); try (Connection c =
		 * dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectOrdering")); ResultSet rs =
		 * ps.executeQuery();) { while (rs.next()) { Ordering ordering = new Ordering();
		 * ordering.setId(rs.getInt("id"));
		 * ordering.setSellingPrice(rs.getInt("sellingPrice"));
		 * ordering.setOrderingDate(rs.getDate("orderingDate")); Customer customer = new
		 * Customer(); customer.setName(rs.getString("name"));
		 * ordering.setCustomer(customer); Book book = new Book();
		 * book.setTitle(rs.getString("title")); ordering.setBook(book);
		 * rtn.add(ordering); }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		// dbutils 적용
		List<Object[]> rtn = new ArrayList<>();

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Object[]>> h = new ArrayListHandler();
			rtn = qr.query(QM.get("selectOrdering"), h);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;

	}

	public void insertOrdering(Ordering ordering) {
		/*
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("insertOrdering"))) { ps.setInt(1,
		 * ordering.getCustomerId()); ps.setInt(2, ordering.getBookId()); ps.setInt(3,
		 * ordering.getSellingPrice()); ps.setDate(4, new java.sql.Date(new
		 * java.util.Date().getTime())); ps.executeUpdate(); } catch (SQLException sqle)
		 * { sqle.printStackTrace(); }
		 */

		// dbutils 적용
		try (Connection c = dataSource.getConnection()) {
			QueryRunner qr = new QueryRunner();
			Object[] p = { ordering.getCustomerId(), ordering.getBookId(), ordering.getSellingPrice(),
					new java.util.Date() };
			qr.execute(c, QM.get("insertOrdering"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public long selectCountByBookId(int bookId) {
		/*
		 * int rtn = -1;
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectCountByBookId"))) { ps.setInt(1, bookId);
		 * try (ResultSet rs = ps.executeQuery();) { if (rs.next()) { rtn =
		 * rs.getInt(1); } }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */
		
		long rtn = -1;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Long> h = new ScalarHandler<Long>();
			Object[] p = { bookId };
			rtn = qr.query(QM.get("selectCountByBookId"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public long selectCountByCustomerId(int customerId) {
		/*
		 * int rtn = -1;
		 * 
		 * try (Connection c = dataSource.getConnection(); PreparedStatement ps =
		 * c.prepareStatement(QM.get("selectCountByCustomerId"))) { ps.setInt(1,
		 * customerId); try (ResultSet rs = ps.executeQuery();) { if (rs.next()) { rtn =
		 * rs.getInt(1); } }
		 * 
		 * } catch (SQLException sqle) { sqle.printStackTrace(); }
		 * 
		 * return rtn;
		 */

		long rtn = -1;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Long> h = new ScalarHandler<Long>();
			Object[] p = { customerId };
			rtn = qr.query(QM.get("selectCountByCustomerId"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

}
