package review.service;

import review.model.Review;
import review.model.ReviewContent;

public class ReviewData {

	private Review review;
	private ReviewContent content;

	public ReviewData(Review Review, ReviewContent content) {
		this.review = Review;
		this.content = content;
	}

	public Review getReview() {
		return review;
	}

	public String getContent() {
		return content.getContent();
	}

}
