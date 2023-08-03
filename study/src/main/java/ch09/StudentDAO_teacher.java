package ch09;

import java.sql.*;
import java.util.*;

public class StudentDAO_teacher {

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
//		try {
//			pstmt.close();
//			conn.close();
		// 밑에는 강사님 스타일
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// 개발 후 이게 좋음
//			System.out.println(e.getMessage());
		}

	}

	public void insert(Student s) {
		open();
		String sql = "INSERT INTO student(username, univ, birth, email) values(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			// create alter drop 은 excute, update는 뭐더라, query는 음...
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<Student> getAll() {
		open();
		List<Student> students = new ArrayList<>();
		// 강사님 습관
//		List<Student> rtn = new ArrayList<>();
//		String sql = "select id, username, univ, birt, email from student";

		try {
			pstmt = conn.prepareStatement("select*from student");
			// 강사님 버전
//			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));

				students.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}
}
