package admin.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.dao.AdminDao;
import admin.model.User;
import jdbc.connection.ConnectionProvider;
import review.dao.ReviewDao;
import review.model.Review;

public class ListUserViewService {

	private AdminDao adminDao = new AdminDao();
	private int size = 10;

	public UserPage getUserPage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = adminDao.selectCount(conn);
			List<User> content = adminDao.search(
					conn, (pageNum - 1) * size, size);
			return new UserPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
