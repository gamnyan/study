package p2;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class OrderingDAO extends MadangDAO {
	Properties sqls;

	public OrderingDAO() {
		super();

		sqls = new Properties();
		try {
			sqls.load(getClass().getResourceAsStream("/p/ordering_sql.properties"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public List<Object[]> select() {
		List<Object[]> rtn = new ArrayList<>();

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Object[]>> h = new ArrayListHandler();
			rtn = qr.query(sqls.getProperty("select"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public void insert(Ordering ordering) {
		try (Connection c = dataSource.getConnection();
				PreparedStatement ps = c.prepareStatement(sqls.getProperty("insert"));) {
			ps.setInt(1, ordering.getCustomerId());
			ps.setInt(2, ordering.getBookId());
			ps.setInt(3, ordering.getSellingPrice());
			ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public long selectCountByCustomerId(int customerId) {
		long rtn = -1;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Long> h = new ScalarHandler<Long>();
			Object[] p = { customerId };
			rtn = qr.query(sqls.getProperty("selectCountByCustomerId"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}
}
