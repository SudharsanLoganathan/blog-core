package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentDAO;
import com.blog.exception.ArticleInvalidException;
import com.blog.exception.CommentsInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.validator.ArticleValidator;
import com.blog.validator.CommentsValidator;

@Service
public class CommentsService {
	@Autowired
	CommentsValidator commentsValidator = new CommentsValidator();
	@Autowired
	CommentDAO commentDAO = new CommentDAO();
	@Autowired
	ArticleValidator articleValidator;
	public void serviceSave(Comment comments) throws ServiceException {
		try {
			commentsValidator.validateSave(comments);
			commentDAO.save(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceUpdate(Comment comments) throws ServiceException {
				try {
			commentsValidator.validateUpdate(comments);
			commentDAO.update(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void serviceDelete(Comment comments) throws ServiceException {
				try {
			commentsValidator.validateDelete(comments);
			commentDAO.delete(comments);
		} catch (CommentsInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<Comment> serviceListAllComments() {
		return commentDAO.list();
	}
	
	public List<Comment> serviceShowCommentsByArticles(Article article) throws ArticleInvalidException, ServiceException{
				try {
			articleValidator.validateTitle(article);
		     return commentDAO.showCommentsByArticles(article);
			
		} catch (ArticleInvalidException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
