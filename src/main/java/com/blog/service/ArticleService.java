package com.blog.service;

import java.util.List;

import com.blog.dao.ArticleCatagoryDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.SeedCatagoryDAO;
import com.blog.exception.ArticleInvalidException;
import com.blog.exception.ServiceException;
import com.blog.exception.UserInvalidException;
import com.blog.model.Article;
import com.blog.model.SeedCatagory;
import com.blog.model.UserDetail;
import com.blog.validator.ArticleValidator;
import com.blog.validator.UserValidator;

public class ArticleService {
	public void serviceSave(Article article) throws ServiceException {
		ArticleValidator articleValidator = new ArticleValidator();
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			articleValidator.validateSave(article);
			articleDAO.save(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(Article article) throws ServiceException {
		ArticleValidator articleValidator = new ArticleValidator();
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			articleValidator.validateUpdate(article);
			articleDAO.update(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(Article article) throws ServiceException {
		ArticleValidator articleValidator = new ArticleValidator();
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			articleValidator.validateDelete(article);
			articleDAO.delete(article);

		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceListAllUsers() {
		ArticleDAO articleDAO = new ArticleDAO();
		System.out.println(articleDAO.list());
	}
	public void postArticleService(Article article,SeedCatagory seedCatagory,ArticleDAO articleDAO,SeedCatagoryDAO seedCatagoryDAO) 
	{
		articleDAO.save(article);
		seedCatagoryDAO.save(seedCatagory);
		ArticleCatagoryDAO articleCategoryDAO = new ArticleCatagoryDAO();
		articleCategoryDAO.save(articleDAO,seedCatagoryDAO);
		
	}
	public void serviceGetArticlesPublishedByUser(UserDetail userDetail) throws UserInvalidException, ServiceException{
        UserValidator userValidator=new UserValidator();
		ArticleDAO articleDAO = new ArticleDAO();
		try {
			userValidator.validateUserName(userDetail);
			List<Article> a=articleDAO.getArticlesPublishedByUser(userDetail);
			for(Article s:a){
				System.out.println(s.getTitle()+" "+s.getContent());
			}
		} catch (UserInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
