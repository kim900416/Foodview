package admin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import admin.dao.AdminDao;
import admin.model.FoodIntroContent;
import jdbc.connection.ConnectionProvider;

public class ListFoodViewService {

	private AdminDao adminDao = new AdminDao();


	public FoodPage getFoodPage() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			List<FoodIntroContent> content = adminDao.search2(conn);
			return new FoodPage(content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
