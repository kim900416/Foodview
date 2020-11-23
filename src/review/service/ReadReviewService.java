package review.service;

import java.sql.Connection;
import java.sql.SQLException;

import review.dao.ReviewContentDao;
import review.dao.ReviewDao;
import review.model.Review;
import review.model.ReviewContent;
import jdbc.connection.ConnectionProvider;

public class ReadReviewService {
	private ReviewDao reviewDao = new ReviewDao();
	private ReviewContentDao contentDao = new ReviewContentDao();
	
	public ReviewData getReview(int reviewNum, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			Review Review = reviewDao.selectById(conn, reviewNum);
			if (Review == null) {
				throw new ReviewNotFoundException();
			}
			ReviewContent content = contentDao.selectById(conn, reviewNum);
			if (content == null) {
				throw new ReviewContentNotFoundException();
			}
			if (increaseReadCount) {
				reviewDao.increaseReadCount(conn, reviewNum);
			}
			return new ReviewData(Review, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
