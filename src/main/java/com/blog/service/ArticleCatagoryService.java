package com.blog.service;

import com.blog.dao.ArticleCatagoryDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.ArticleCatagoryInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.ArticleCatagory;
import com.blog.validator.ArticleCatagoryValidator;

public class ArticleCatagoryService {
	public void serviceSave(final ArticleDAO articleDAO,SeedCatagoryDAO seedCatagoryDAO,ArticleCatagory articleCatagory) throws ServiceException {
		ArticleCatagoryValidator articleCatagoryValidator = new ArticleCatagoryValidator();
		ArticleCatagoryDAO articleCatagoryDAO = new ArticleCatagoryDAO();
		try {
			articleCatagoryValidator.validateSave(articleCatagory);
			articleCatagoryDAO.save(articleDAO,seedCatagoryDAO);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(ArticleCatagory articleCatagory) throws ServiceException {
		ArticleCatagoryValidator articleCatagoryValidator = new ArticleCatagoryValidator();
		ArticleCatagoryDAO articleCatagoryDAO = new ArticleCatagoryDAO();
		try {
			articleCatagoryValidator.validateUpdate(articleCatagory);
			articleCatagoryDAO.update(articleCatagory);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(ArticleCatagory articleCatagory) throws ServiceException {
		ArticleCatagoryValidator articleCatagoryValidator = new ArticleCatagoryValidator();
		ArticleCatagoryDAO articleCatagoryDAO = new ArticleCatagoryDAO();
		try {
			articleCatagoryValidator.validateDelete(articleCatagory);
			articleCatagoryDAO.delete(articleCatagory);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllArticleCatagory() {
		ArticleCatagoryDAO articleCatagoryDAO = new ArticleCatagoryDAO();
		articleCatagoryDAO.list();
	}

}
