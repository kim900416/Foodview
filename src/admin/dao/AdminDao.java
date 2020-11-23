package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.model.FoodIntro;
import admin.model.FoodIntroContent;
import admin.model.User;
import jdbc.JdbcUtil;

public class AdminDao {
	
	private User convertUser(ResultSet rs) throws SQLException {
		return new User(
				rs.getString("u_name"),				
				rs.getString("u_id"),
				rs.getString("u_phonNum"),
				rs.getString("u_email"),
				rs.getString("u_sex"),
				rs.getString("u_grade"));					
	}
	
	private FoodIntroContent convertFood(ResultSet rs) throws SQLException {
		return new FoodIntroContent(
				rs.getString("f_imageAddress"),				
				rs.getString("f_title"),
				rs.getString("content"),
				rs.getString("introduce"),
				rs.getString("f_grade"),
				rs.getInt("f_num"),
				rs.getInt("f_view_num"));					
	}
	
	public void changeUserGrade(Connection conn, String id, String grade, String black) 
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update user_info set u_grade = ?, blacklist = ? where u_id = ?")) {
			pstmt.setString(1, grade);
			pstmt.setString(2, black);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}
	}
	
	public void changefoodGrade(Connection conn, String fgrade, String fnum) 
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update food_info_content set f_grade = ? where f_num = ? ")) {
			pstmt.setString(1, fgrade);
			pstmt.setString(2, fnum);
			pstmt.executeUpdate();
		}
	}

	public List<User> search(Connection conn, int start, int size) 
			throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from user_info " +
					"order by u_num desc limit ?, ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<User> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertUser(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
	}
	
	public List<FoodIntroContent> search2(Connection conn) 
			throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from food_info_content order by f_num desc");
			
			rs = pstmt.executeQuery();
			List<FoodIntroContent> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertFood(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
	}
	
	public User selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from review_info where u_num = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			User UserGrade = null;
			if (rs.next()) {
				UserGrade = convertUser(rs);
			}
			return UserGrade;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public User selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from user_info where u_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			User user = null;
			if (rs.next()) {
				user = new User(
						rs.getString("u_name"), 
						rs.getString("u_id"), 
						rs.getString("u_phonNum"),
						rs.getString("u_email"),
						rs.getString("u_sex"),
						rs.getString("u_grade"));											
			}
			return user;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}	
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from user_info");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public int selectCount2(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from food_info_content");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public FoodIntro insert(Connection conn, FoodIntro foodIntro) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into food_info "
					+ "(f_name) "
					+ "values (?)");
			pstmt.setString(1, foodIntro.getName());			
			//pstmt.setTimestamp(5, toTimestamp(Review.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from food_info");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new FoodIntro(
							newNo,							
							foodIntro.getName()							
							);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

}
