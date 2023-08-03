package p;

import java.sql.*;
import java.util.*;

public class BookDAO extends MadangDAO{
	
	public BookDAO() {
		super();
	}
	
	public List<Book> select() {
		List<Book> rtn = new ArrayList<>();

		String sql = "SELECT id, title, publisher, price FROM book";
		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				rtn.add(book);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public Book selectById(int id) {
		Book rtn = null;

		String sql = "SELECT id, title, publisher, price FROM book WHERE id = ?";
		try (Connection c = dataSource.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Book book = new Book();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setPublisher(rs.getString("publisher"));
					book.setPrice(rs.getInt("price"));
				}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
}
