package admin.service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.dao.AdminContentDao;
import admin.dao.AdminDao;
import admin.model.FoodIntro;
import admin.model.FoodIntroContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class FoodGradeService {

	private AdminDao dao = new AdminDao();	

	public void foodChangGrade(String fgrade, String fnum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			dao.changefoodGrade(conn,fgrade,fnum);			
			conn.commit();			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}