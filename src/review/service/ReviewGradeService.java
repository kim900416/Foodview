package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import review.dao.ReviewContentDao;
import review.dao.ReviewDao;
import review.model.Review;
import review.model.ReviewContent;

public class ReviewGradeService {

	private ReviewDao ReviewDao = new ReviewDao();	

	public String bringGrade(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Review Review = toReview(req);
			String grade = ReviewDao.countGrade(conn, Review);
			if (grade == null) {
				throw new RuntimeException("fail to bring grade");
			}			
			conn.commit();
			return grade;
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
