package com.blog.validator;

import com.blog.exception.ArticleInvalidException;
import com.blog.model.Article;

public class ArticleValidator {
	
	public void validateSave(Article article) throws ArticleInvalidException {
		if (article.getUserId().getId()< 0) {
			throw new ArticleInvalidException("Invalid ID");
		} else if (article.getTitle() == null || "".equals(article.getTitle().trim())) {
			throw new ArticleInvalidException("Invalid Title");
		} else if (article.getCreatedDate() == null) {
			throw new ArticleInvalidException("Invalid Date");
		} else if (article.getContent() == null || "".equals(article.getContent().trim())) {
			throw new ArticleInvalidException("Invalid Content");
		} else if (article.getModifiedDate() == null) {
			throw new ArticleInvalidException("Invalid date");
		}
	}

	public void validateUpdate(Article article) throws ArticleInvalidException {
		if (article.getTitle() == null || "".equals(article.getTitle().trim())) {
			throw new ArticleInvalidException("Invalid Title");

		} else if (article.getContent() == null || "".equals(article.getContent().trim())) {
			throw new ArticleInvalidException("Invalid Content");
		} else if (article.getId() < 0) {
			throw new ArticleInvalidException("Invalid ID");
		}

	}

	public void validateDelete(Article article) throws ArticleInvalidException {
		if (article.getId() < 0) {
			throw new ArticleInvalidException("Invalid ID");
		}
	}
	public void validateTitle(Article article) throws ArticleInvalidException {
		if (article.getTitle() == null || "".equals(article.getTitle().trim())) {
			throw new ArticleInvalidException("Invalid Title");
		}
	}
}
