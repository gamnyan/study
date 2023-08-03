package restaurant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class RestaurantDAO {
	protected DataSource dataSource;

	final static String QUERY_PATH = "/restaurant/restaurant_sql.properties";
	final static Map<String, String> QM;
	static {
		try {
			QM = QueryLoader.instance().load(QUERY_PATH);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new ExceptionInInitializerError(ioe);
		}
	}

	public RestaurantDAO() {
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/jwbookdb");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

	public List<Coupon> selectCoupon() {
		List<Coupon> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Coupon>> h = new BeanListHandler<>(Coupon.class);
			rtn = qr.query(QM.get("selectCoupon"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<Card> selectCard() {
		List<Card> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Card>> h = new BeanListHandler<>(Card.class);
			rtn = qr.query(QM.get("selectCard"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}

	public List<Menu> selectMenu() {
		List<Menu> rtn = new ArrayList<>();
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Menu>> h = new BeanListHandler<>(Menu.class);
			rtn = qr.query(QM.get("selectMenu"), h);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
	public List<Object[]> selectBill(){
		List<Object[]> rtn = new ArrayList<>();

		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Object[]>> h = new ArrayListHandler();
			rtn = qr.query(QM.get("selectBill"), h);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
	public List<Object[]> selectLineItem(){
		List<Object[]> rtn = new ArrayList<>();
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<List<Object[]>> h = new ArrayListHandler();
			rtn = qr.query(QM.get("selectLineItem"), h);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
	public Coupon selectCouponById(int id) {
		Coupon rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Coupon> h = new BeanHandler<>(Coupon.class);
			Object[] p = { id };
			rtn = qr.query(QM.get("selectCouponById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	public Card selectCardById(int id) {
		Card rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Card> h = new BeanHandler<>(Card.class);
			Object[] p = { id };
			rtn = qr.query(QM.get("selectCardById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
	public Menu selectMenuById(int id) {
		Menu rtn = null;
		
		try {
			QueryRunner qr = new QueryRunner(dataSource);
			ResultSetHandler<Menu> h = new BeanHandler<>(Menu.class);
			Object[] p = { id };
			rtn = qr.query(QM.get("selectMenuById"), h, p);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rtn;
	}
	
	public void insertBill(Bill bill) {
		try(Connection c = dataSource.getConnection()){
			c.setAutoCommit(false);
			try {
				QueryRunner qr = new QueryRunner();
				ScalarHandler<Long> h = new ScalarHandler<>();
				Object[] p = {};
				p = new Object[] {
						bill.getCardId() == -1 ? null : bill.getCardId(),
						bill.getCouponId() == -1 ? null : bill.getCouponId(),
						bill.getPrice(),
						bill.getDiscountPrice(),
						new java.util.Date()
				};
				long billId = qr.insert(c, QM.get("insertBill"), h, p);
				for(LineItem lineItem : bill.getLineItem()) {
					p = new Object[] {billId, lineItem.getMenuId(), lineItem.getMenuQuantity()};
					qr.insert(c, QM.get("insertLineItem"), h, p);
				}
				c.commit();
			} catch(SQLException sqle) {
				c.rollback();
				sqle.printStackTrace();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
//
//	// 뉴스 한 개를 클릭했을 때 세부 내용을 보여주는 메서드
//	public News getNews(int aid) throws SQLException {
//		Connection conn = open();
//		News n = new News();
//		String sql = "select aid, title, img, FORMATDATETIME(date, 'yyyy-MM-dd hh:mm:ss')as cdate, content from news where aid=?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, aid);
//		ResultSet rs = pstmt.executeQuery();
//		rs.next();
//
//		try (conn; pstmt; rs) {
//			n.setAid(rs.getInt("aid"));
//			n.setTitle(rs.getString("title"));
//			n.setImg(rs.getString("img"));
//			n.setDate(rs.getString("cdate"));
//			n.setContent(rs.getString("content"));
//			pstmt.executeQuery();
//			return n;
//		}
//	}
//
//	// 뉴스 추가 메서드
//	public void addNews(News n) throws Exception {
//		Connection conn = open();
//		String sql = "insert into news(title, img, date, content) values(?,?,CURRENT_TIMESTAMP(),?)";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		try (conn; pstmt) {
//			pstmt.setString(1, n.getTitle());
//			pstmt.setString(2, n.getImg());
//			pstmt.setString(3, n.getContent());
//			pstmt.executeUpdate();
//		}
//	}
//
//	// 뉴스 삭제 메서드
//	public void delNews(int aid) throws SQLException {
//		Connection conn = open();
//		String sql = "delete from news where aid=?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		try (conn; pstmt) {
//			pstmt.setInt(1, aid);
//			if (pstmt.executeUpdate() == 0) {
//				throw new SQLException("DB에러");
//			}
//		}
//	}
}
