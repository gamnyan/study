package teacherEx;

import java.sql.*;
import java.util.*;

public class TeacherDbMandartDAO {

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

	public String getFirstGoal() {
		String rtn = null;
		open();

		String sql = "SELECT name FROM first_goal WHERE id = 1";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rtn = rs.getString("name");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return rtn;
	}

	public List<String> getSecondGoals() {
		List<String> rtn = new ArrayList<>();
		open();

		String sql = "SELECT name FROM second_goal WHERE firstId = 1";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				rtn.add(name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return rtn;
	}

	public int getSecondIdByName(String name) {
		int rtn = 0;
		open();

		String sql = "SELECT id FROM second_goal WHERE name = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rtn = rs.getInt("id");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return rtn;
	}

	public List<String> getThirdGoalsBySecondId(int secondId) {
		List<String> rtn = new ArrayList<>();
		open();

		String sql = "SELECT name FROM third_goal WHERE secondId = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, secondId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				rtn.add(name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return rtn;
	}
}
