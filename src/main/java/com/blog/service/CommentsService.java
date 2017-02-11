package com.blog.service;

import java.util.List;

import com.blog.dao.CommentDAO;
import com.blog.exception.ArticleInvalidException;
import com.blog.exception.CommentsInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.validator.ArticleValidator;
import com.blog.validator.CommentsValidator;

public class CommentsService {
	public void serviceSave(Comment comments) throws ServiceException {
		CommentsValidator commentsValidator = new CommentsValidator();
		CommentDAO commentDAO = new CommentDAO();

		try {
			commentsValidator.validateSave(comments);
			commentDAO.save(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(Comment comments) throws ServiceException {
		CommentsValidator commentsValidator = new CommentsValidator();
		CommentDAO commentDAO = new CommentDAO();

		try {
			commentsValidator.validateUpdate(comments);
			commentDAO.update(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(Comment comments) throws ServiceException {
		CommentsValidator commentsValidator = new CommentsValidator();
		CommentDAO commentDAO = new CommentDAO();

		try {
			commentsValidator.validateDelete(comments);
			commentDAO.delete(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Comment> serviceListAllComments() {
		CommentDAO commentDAO = new CommentDAO();
		return commentDAO.list();
	}
	public List<Comment> serviceShowCommentsByArticles(Article article) throws ArticleInvalidException, ServiceException{
		ArticleValidator articleValidator=new ArticleValidator();
		CommentDAO commentDAO = new CommentDAO();

		try {
			articleValidator.validateTitle(article);
		     return commentDAO.showCommentsByArticles(article);
			
		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
