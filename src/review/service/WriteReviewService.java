package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import review.dao.ReviewContentDao;
import review.dao.ReviewDao;
import review.model.Review;
import review.model.ReviewContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteReviewService {

	private ReviewDao ReviewDao = new ReviewDao();
	private ReviewContentDao contentDao = new ReviewContentDao();

	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Review Review = toReview(req);
			Review savedReview = ReviewDao.insert(conn, Review);
			if (savedReview == null) {
				throw new RuntimeException("fail to insert Review");
			}
			ReviewContent content = new ReviewContent(
					savedReview.getNumber(),
					req.getContent());
			ReviewContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert Review_content");
			}

			conn.commit();

			return savedReview.getNumber();
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

	private Review toReview(WriteRequest req) {
		Date now = new Date();
		return new Review(null, req.getWriter(),req.getTitle(),
				req.getGrade(),req.getFnum(), now, 0);
	}
}
