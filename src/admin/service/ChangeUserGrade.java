package admin.service;
/*
import java.sql.Connection;
import java.sql.SQLException;

import admin.dao.AdminDao;
import admin.model.User;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.service.MemberNotFoundException;

public class ChangeUserGrade {
	
	private AdminDao adminDao = new AdminDao();
	
	public void changeGrade(String userId, String grade, String newGrade) {		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);	
			
			User user = adminDao.selectById(conn, userId);			
			if (user == null) {
				throw new MemberNotFoundException();
			}			
			user.changeGrade(newGrade);
			adminDao.changeUserGrade(conn, user);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}

*/
