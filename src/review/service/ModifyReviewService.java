package review.service;

import java.sql.Connection;
import java.sql.SQLException;

import review.dao.ReviewContentDao;
import review.dao.ReviewDao;
import review.model.Review;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyReviewService {

	private ReviewDao ReviewDao = new ReviewDao();
	private ReviewContentDao contentDao = new ReviewContentDao();

	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Review Review = ReviewDao.selectById(conn, 
					modReq.getReviewNumber());
			if (Review == null) {
				throw new ReviewNotFoundException();
			}
			if (!canModify(modReq.getUserId(), Review)) {
				throw new PermissionDeniedException();
			}
			ReviewDao.update(conn, 
					modReq.getReviewNumber(), modReq.getTitle());
			contentDao.update(conn, 
					modReq.getReviewNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String modfyingUserId, Review Review) {
		return Review.getWriter().getId().equals(modfyingUserId);
	}
}
