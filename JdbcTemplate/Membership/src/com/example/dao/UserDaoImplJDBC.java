//package com.example.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.example.vo.UserVO;
//
////3. Data Access Layer -> JDBC Interface(JDBC방법)
//@Repository("userDao")
//public class UserDaoImplJDBC implements UserDao {
//	@Autowired
//	private DataSource dataSource;
//
//	@Override
//	public void insert(UserVO user) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = this.dataSource.getConnection(); // 2,3
//			String sql = "INSERT INTO users (userid, name, gender,city) VALUES (?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(sql); // 4
//			pstmt.setString(1, user.getUserId());
//			pstmt.setString(2, user.getName());
//			pstmt.setString(3, user.getGender());
//			pstmt.setString(4, user.getCity());
//			pstmt.executeUpdate(); // 5
//			System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close(); // 6
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			}
//		}
//	}
//
//	@Override
//	public List<UserVO> readAll() {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		List<UserVO> userList = null;
//		try {
//			conn = this.dataSource.getConnection(); // 2,3
//			stmt = conn.createStatement(); // 4
//			rs = stmt.executeQuery("SELECT * FROM users ORDER BY userid"); // 5
//			userList = new ArrayList<UserVO>();
//			while (rs.next()) { // 6
//				UserVO userVO = new UserVO(rs.getString("userid"), rs.getString("name"), rs.getString("gender"),
//						rs.getString("city"));
//				userList.add(userVO);
//			}
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close(); // 7
//				if (stmt != null)
//					stmt.close();
//				if (rs != null)
//					rs.close();
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			}
//		}
//		return userList;
//	}
//
//	@Override
//	public void update(UserVO user) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = this.dataSource.getConnection();
//			String sql = "UPDATE users SET name = ?, gender = ?, city = ? WHERE userid = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user.getName());
//			pstmt.setString(2, user.getGender());
//			pstmt.setString(3, user.getCity());
//			pstmt.setString(4, user.getUserId());
//			pstmt.executeUpdate();
//			System.out.println("갱신된 Record with ID = " + user.getUserId());
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			}
//		}
//	}
//
//	@Override
//	public void delete(String id) {
//		Connection conn = null; 
//		PreparedStatement pstmt = null;
//		try {
//			conn = this.dataSource.getConnection(); // 2,3
//			pstmt = conn.prepareStatement("DELETE FROM users WHERE userid = ?"); // 4
//			pstmt.setString(1, id);
//			pstmt.executeUpdate(); // 5
//			System.out.println("삭제된 Record with ID = " + id);
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (conn != null) conn.close(); // 6
//				if (pstmt != null) pstmt.close();
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			}
//		}
//	}
//
//	@Override
//	public UserVO read(String id) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		UserVO userVO = null;
//		try {
//			conn = this.dataSource.getConnection(); // 2, 3
//			pstmt = conn.prepareStatement("SELECT * FROM users WHERE userid = ?"); // 4
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery(); // 5
//			rs.next(); // 6
//			userVO = new UserVO(rs.getString("userid"), rs.getString("name"), rs.getString("gender"),
//					rs.getString("city"));
//		} catch (SQLException ex) {
//			System.out.println(ex);
//		} finally {
//			try {
//				if (conn != null)
//					conn.close(); // 7
//				if (pstmt != null)
//					pstmt.close();
//				if (rs != null)
//					rs.close();
//			} catch (SQLException ex) {
//				System.out.println(ex);
//			}
//		}
//		return userVO;
//	}
//
//}
