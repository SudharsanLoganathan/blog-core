package com.blog.validator;

import org.springframework.stereotype.Repository;

import com.blog.exception.CommentsInvalidException;
import com.blog.model.Comment;

@Repository
public class CommentsValidator {

	public void validateSave(Comment comments) throws CommentsInvalidException {
		if (comments.getArticleId().getId() <= 0) {
			throw new CommentsInvalidException("Invalid Article ID");
		} else if (comments.getComments() == null || "".equals(comments.getComments().trim())) {
			throw new CommentsInvalidException("Invalid comment");
		} else if (comments.getUserId().getId() <= 0) {
			throw new CommentsInvalidException("Invalid User Id");
		}

	}

	public void validateUpdate(Comment comments) throws CommentsInvalidException {
		if (comments.getArticleId().getId() <= 0) {
			throw new CommentsInvalidException("Invalid Article ID");
		} else if (comments.getComments() == null || "".equals(comments.getComments())) {
			throw new CommentsInvalidException("Invalid comment");
		}
	}

	public void validateDelete(Comment comments) throws CommentsInvalidException {
		if (comments.getArticleId().getId() <= 0) {
			throw new CommentsInvalidException("Invalid Article ID");
		}
	}

}
