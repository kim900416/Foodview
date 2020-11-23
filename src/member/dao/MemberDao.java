package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {

	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from user_info where u_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member(
						rs.getString("u_id"), 
						rs.getString("u_name"), 
						rs.getString("u_pwd"),
						rs.getString("u_sex"),
						rs.getString("u_email"),
						rs.getString("u_phonNum"),
						rs.getString("u_grade"),
						toDate(rs.getTimestamp("u_reg_date")));						
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void newInsert(Connection conn, Member mem) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
				"insert into user_info "
				+ "(u_id, u_name, u_pwd, u_sex, u_email,"
				+ "u_phonNum, u_grade, u_reg_date, blacklist) "
				+ "values(?,?,?,?,?,?,?,?,0)")) {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getSex());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhonNum());
			pstmt.setString(7, mem.getGrade());
			pstmt.setTimestamp(8, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update user_info set u_name = ?, "
				+ "u_pwd = ? where u_id = ?")) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		}
	}
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
}

	