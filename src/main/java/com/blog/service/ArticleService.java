package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.ArticleCatagoryDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.ArticleInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.SeedCatagory;
import com.blog.model.UserDetail;
import com.blog.validator.ArticleValidator;

@Service
public class ArticleService {
	@Autowired
	ArticleValidator articleValidator = new ArticleValidator();
	@Autowired
	ArticleDAO articleDAO;
	@Autowired
	ArticleCatagoryDAO articleCategoryDAO;
	public void serviceSave(Article article) throws ServiceException {
		
		try {
			articleValidator.validateSave(article);
			articleDAO.save(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(Article article) throws ServiceException {

		try {
			articleValidator.validateUpdate(article);
			articleDAO.update(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(Article article) throws ServiceException {
		
		try {
			articleValidator.validateDelete(article);
			articleDAO.delete(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Article> serviceListAllArticles() {
		return articleDAO.list();
	}
	public void postArticleService(Article article,SeedCatagory seedCatagory,ArticleDAO articleDAO,SeedCatagoryDAO seedCatagoryDAO) 
	{
		articleDAO.save(article);
		seedCatagoryDAO.save(seedCatagory);
		articleCategoryDAO.save(articleDAO,seedCatagoryDAO);
		
	}
	public List<Article> serviceGetArticlesPublishedByUser(UserDetail userDetail) {
		  return articleDAO.getArticlesPublishedByUser(userDetail);
		
	}


public UserDetail serviceGetEmailByArticleId(int article) throws ServiceException{
	    ArticleDAO articleDAO = new ArticleDAO();
		return articleDAO.getEmailByArticleId(article);
}
}
