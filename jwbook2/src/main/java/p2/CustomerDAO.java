package p2;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CustomerDAO extends MadangDAO {
	final static String QUERY_PATH = "/p/customer_sql.properties";
	final static Map<String, String> QM;
	
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
		} catch(IOException ioe) {
			ioe.printStackTrace();
			
			throw new ExceptionInInitializerError(ioe);
		}
	}

	public CustomerDAO() {
		super();
	}

	public List<Customer> select() {
		List<Customer> rtn = new ArrayList<>();

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Customer>> h = new BeanListHandler<>(Customer.class);
			rtn = qr.query(QM.get("select"), h);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public Customer selectById(int id) {
		Customer rtn = null;

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Customer> h = new BeanHandler<>(Customer.class);
			Object[] p = {id};
			rtn = qr.query(QM.get("selectById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return rtn;
	}

	public void insert(Customer customer) {
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = {customer.getName(), customer.getAddress(), customer.getPhone()};
			qr.execute(QM.get("insert"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	public void update(Customer customer) {
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = {customer.getName(), customer.getAddress(), customer.getPhone(), customer.getId()};
			qr.execute(QM.get("update"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	public void delete(int id) throws HasOrderingException {
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			Object[] p = {id};
			qr.execute(QM.get("delete"), p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
