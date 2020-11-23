package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import review.dao.ReviewDao;
import review.model.Review;
import jdbc.connection.ConnectionProvider;

public class ListReviewService {

	private ReviewDao reviewDao = new ReviewDao();
	private int size = 10;

	public ReviewPage getReviewPage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = reviewDao.selectCount(conn);
			List<Review> content = reviewDao.select(
					conn, (pageNum - 1) * size, size);
			return new ReviewPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ReviewPage getReviewPage(int pageNum, String fnum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = reviewDao.selectCount(conn, fnum);
			List<Review> content = reviewDao.select(
					conn, (pageNum - 1) * size, size, fnum);
			return new ReviewPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
