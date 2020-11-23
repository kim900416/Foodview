package admin.service;

import java.sql.Connection;
import java.sql.SQLException;

import admin.dao.AdminContentDao;
import admin.dao.AdminDao;
import admin.model.FoodIntro;
import admin.model.FoodIntroContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteFoodIntroService {

	private AdminDao dao = new AdminDao();
	private AdminContentDao contentDao = new AdminContentDao();

	public Integer write(WriteFoodIntroRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			FoodIntro foodIntro = toFoodIntro(req);
			FoodIntro savedFoodIntro = dao.insert(conn, foodIntro);
			if (savedFoodIntro == null) {
				throw new RuntimeException("fail to insert Review");
			}
			FoodIntroContent content = new FoodIntroContent(
					savedFoodIntro.getNumber(),
					req.getImageAddress(),
					req.getTitle(),
					req.getContent(),
					req.getIntroduce(),
					req.getFnum());
			FoodIntroContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert Review_content");
			}

			conn.commit();

			return savedFoodIntro.getNumber();
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
	
	private FoodIntro toFoodIntro(WriteFoodIntroRequest req) {
		return new FoodIntro(null, req.getName());
	}
}
