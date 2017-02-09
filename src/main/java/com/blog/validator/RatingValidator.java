package com.blog.validator;

import com.blog.exception.RatingInvalidException;
import com.blog.model.RatingGiven;

public class RatingValidator {

	public void validateSave(RatingGiven ratingGiven) throws RatingInvalidException {
		if (ratingGiven.getArticleId().getId() <= 0) {
			throw new RatingInvalidException("Invalid Article ID");
		} else if (ratingGiven.getUserId().getId() <= 0) {
			throw new RatingInvalidException("Invalid user ID");
		} else if (ratingGiven.getRatings() < 0) {
			throw new RatingInvalidException("Invalid rating value");
		}
	}

	public void validateUpdate(RatingGiven ratingGiven) throws RatingInvalidException {
		if (ratingGiven.getArticleId().getId() <= 0) {
			throw new RatingInvalidException("Invalid Article ID");
		} else if (ratingGiven.getRatings() < 0) {
			throw new RatingInvalidException("Invalid rating value");
		}
	}

	public void validateDelete(RatingGiven ratingGiven) throws RatingInvalidException {
		if (ratingGiven.getArticleId().getId() <= 0) {
			throw new RatingInvalidException("Invalid Article ID");
		}
	}
}
