package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleCatagoryDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.ArticleCatagoryInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.ArticleCatagory;
import com.blog.validator.ArticleCatagoryValidator;

@Service
public class ArticleCatagoryService {
	@Autowired
	ArticleCatagoryValidator articleCatagoryValidator = new ArticleCatagoryValidator();
	@Autowired
	ArticleCatagoryDAO articleCatagoryDAO = new ArticleCatagoryDAO();
	public void serviceSave(final ArticleDAO articleDAO,SeedCatagoryDAO seedCatagoryDAO,ArticleCatagory articleCatagory) throws ServiceException {
		
		try {
			articleCatagoryValidator.validateSave(articleCatagory);
			articleCatagoryDAO.save(articleDAO,seedCatagoryDAO);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(ArticleCatagory articleCatagory) throws ServiceException {
		
		try {
			articleCatagoryValidator.validateUpdate(articleCatagory);
			articleCatagoryDAO.update(articleCatagory);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(ArticleCatagory articleCatagory) throws ServiceException {
		
		try {
			articleCatagoryValidator.validateDelete(articleCatagory);
			articleCatagoryDAO.delete(articleCatagory);
		} catch (ArticleCatagoryInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllArticleCatagory() {
		articleCatagoryDAO.list();
	}

}
