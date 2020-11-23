package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import admin.dao.AdminDao;
import admin.model.UserVariable;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ChangeUserGradeService {


		private AdminDao adminDao = new AdminDao();
		private UserVariable user;
		public void changeUserG(ArrayList<UserVariable> list) {
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);
				for(int i=0; i<list.size(); i++) {
				user = list.get(i);				
				adminDao.changeUserGrade(conn, user.getUserId(), user.getGradeValue(), 
						user.getBlackListValue());
				
				if (user == null) {
					throw new UserNotFoundException();
				}
				conn.commit();
				}
			} catch (SQLException e) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException(e);
			} finally {
				JdbcUtil.close(conn);
			}
		}
}
		


