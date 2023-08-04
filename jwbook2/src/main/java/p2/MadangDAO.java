package p2;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MadangDAO {
	protected DataSource dataSource;

	public MadangDAO() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
}
