package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.RatingGivenDAO;
import com.blog.exception.RatingInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.RatingGiven;
import com.blog.validator.RatingValidator;

@Service
public class RatingService {
	@Autowired
	RatingValidator ratingValidator = new RatingValidator();
	@Autowired
	RatingGivenDAO ratingGivenDAO = new RatingGivenDAO();
	public void serviceSave(RatingGiven ratingGiven) throws ServiceException {
		try {
			ratingValidator.validateSave(ratingGiven);
			ratingGivenDAO.save(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(RatingGiven ratingGiven) throws ServiceException {
			try {
			ratingValidator.validateUpdate(ratingGiven);
			ratingGivenDAO.update(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(RatingGiven ratingGiven) throws ServiceException {
		try {
			ratingValidator.validateDelete(ratingGiven);
			ratingGivenDAO.delete(ratingGiven);
		} catch (RatingInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllRatings() {
		ratingGivenDAO.list();
	}
}
