package review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import review.model.Review;
import review.model.Writer;
import jdbc.JdbcUtil;

public class ReviewDao {

	public Review insert(Connection conn, Review Review) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into review_info "
					+ "(r_id, r_name, r_grade_num, r_title, f_num, r_reg_date) "
					+ "values (?,?,?,?,?,?)");
			pstmt.setString(1, Review.getWriter().getId());
			pstmt.setString(2, Review.getWriter().getName());
			pstmt.setString(3, Review.getGrade());
			pstmt.setString(4, Review.getTitle());
			pstmt.setString(5, Review.getFnum());
			pstmt.setTimestamp(6, toTimestamp(Review.getRegDate()));
			//pstmt.setTimestamp(5, toTimestamp(Review.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from review_info");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new Review(newNo,
							Review.getWriter(),
							Review.getTitle(),
							Review.getGrade(),
							Review.getFnum(),
							Review.getRegDate(),
							//Review.getModifiedDate(),
							0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from review_info");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public int selectCount(Connection conn, String fnum) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {			
			pstmt = conn.prepareStatement("select count(*) from review_info where f_num=?");
			pstmt.setString(1, fnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	

	public String countGrade(Connection conn, Review Review) 
			throws SQLException {
		double gradeNum = 0;
		double num = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			pstmt = conn.prepareStatement("select * from review_info where f_num =?");
			pstmt.setString(1, Review.getFnum());			
			rs = pstmt.executeQuery();				
			while (rs.next()) {
				num += 1;
				gradeNum += convertGradeReview(rs);				
			}
			if(Double.toString(num)==null){ return "정보값없음"; }
			return String.format("%.2f",gradeNum/num);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
	}
	
	public List<Review> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from review_info " +
					"order by r_num desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Review> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReview(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Review> select(Connection conn, int startRow, int size, String fnum) 
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from review_info where f_num = ? "+
			" order by r_num desc limit ?, ?");
			pstmt.setString(1, fnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, size);
			rs = pstmt.executeQuery();
			List<Review> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReview(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Review convertReview(ResultSet rs) throws SQLException {
		return new Review(rs.getInt("r_num"),
				new Writer(
						rs.getString("r_id"),
						rs.getString("r_name")),
				rs.getString("r_title"),
				rs.getString("r_grade_num"),
				rs.getString("f_num"),
				toDate(rs.getTimestamp("r_reg_date")),				
				rs.getInt("r_read_cnt"));
	}	
	
	private int convertGradeReview(ResultSet rs) throws SQLException {
		return Integer.parseInt(rs.getString("r_grade_num"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Review selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from review_info where r_num = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Review Review = null;
			if (rs.next()) {
				Review = convertReview(rs);
			}
			return Review;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update review_info set r_read_cnt = r_read_cnt + 1 "+
						"where r_num = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update review_info set r_title = ?"+
						"where r_num = ?")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
