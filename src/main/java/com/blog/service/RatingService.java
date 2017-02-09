package com.blog.service;

import com.blog.dao.RatingGivenDAO;
import com.blog.exception.RatingInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.RatingGiven;
import com.blog.validator.RatingValidator;

public class RatingService {
	public void serviceSave(RatingGiven ratingGiven) throws ServiceException {
		RatingValidator ratingValidator = new RatingValidator();
		RatingGivenDAO ratingGivenDAO = new RatingGivenDAO();

		try {
			ratingValidator.validateSave(ratingGiven);
			ratingGivenDAO.save(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(RatingGiven ratingGiven) throws ServiceException {
		RatingValidator ratingValidator = new RatingValidator();
		RatingGivenDAO ratingGivenDAO = new RatingGivenDAO();

		try {
			ratingValidator.validateUpdate(ratingGiven);
			ratingGivenDAO.update(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(RatingGiven ratingGiven) throws ServiceException {
		RatingValidator ratingValidator = new RatingValidator();
		RatingGivenDAO ratingGivenDAO = new RatingGivenDAO();
		try {
			ratingValidator.validateDelete(ratingGiven);
			ratingGivenDAO.delete(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllRatings() {
		RatingGivenDAO ratingGivenDAO = new RatingGivenDAO();
		ratingGivenDAO.list();
	}
}
