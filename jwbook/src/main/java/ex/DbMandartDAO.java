package ex;

import java.sql.*;
import java.util.*;

public class DbMandartDAO {

	Connection conn = null;
	PreparedStatement pstmt;

	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/C:/Java/H2/data/jwbookdb";

	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa", "sa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@SuppressWarnings("unchecked")
//	public Map<String, List<DbMandart>> getAll() {
//		Map<String, List<String>> firstDbMandartMap = new HashMap<>();
//		firstDbMandartMap.put("점심", Arrays.asList("id", "중식", "일식", "고기", "라면", "한식", "치킨", "디저트", "기타"));
//
//		List<String> firstDbMandartList = new ArrayList<>();
//		firstDbMandartList.addAll(firstDbMandartMap.get("점심"));
//		firstDbMandartList.add(4, "점심");
//
//		Map<String, List<DbMandart>> secondDbMandartMap = new HashMap<>();
//		List<DbMandart> secondDbMandartList = new ArrayList<>();
//
//		try {
//			pstmt = conn.prepareStatement("select * from lunch_mandart");
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				DbMandart dm = new DbMandart();
//				dm.setId(rs.getInt("id"));
//				dm.setChinese(rs.getString("chinese"));
//				dm.setJapanese(rs.getString("japanese"));
//				dm.setBeef(rs.getString("beef"));
//				dm.setLamyeon(rs.getString("lamyeon"));
//				dm.setKorean(rs.getString("korean"));
//				dm.setChicken(rs.getString("chicken"));
//				dm.setDessert(rs.getString("dessert"));
//				dm.setEtc(rs.getString("etc"));
//				secondDbMandartList.add(dm);
//				for (String s : firstDbMandartMap.get("점심")) {
//					secondDbMandartMap.put(s, (List<DbMandart>) dm);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//
//		return secondDbMandartMap;
//
//	}

	public List<DbMandart> getAll() {
		open();
		List<DbMandart> dbMandarts = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement("select * from lunch_mandart");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				DbMandart dm = new DbMandart();
				dm.setId(rs.getInt("id"));
				dm.setChinese(rs.getString("chinese"));
				dm.setJapanese(rs.getString("japanese"));
				dm.setBeef(rs.getString("beef"));
				dm.setLamyeon(rs.getString("lamyeon"));
				dm.setKorean(rs.getString("korean"));
				dm.setChicken(rs.getString("chicken"));
				dm.setDessert(rs.getString("dessert"));
				dm.setEtc(rs.getString("etc"));
				
				dbMandarts.add(dm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dbMandarts;
	}
}
