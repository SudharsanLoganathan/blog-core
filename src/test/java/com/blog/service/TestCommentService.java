package com.blog.service;

import java.util.List;

import com.blog.dao.CommentDAO;
import com.blog.exception.ArticleInvalidException;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.Comment;

public class TestCommentService {

	public static void main(String[] args) throws ArticleInvalidException {
		/*   //All the comments related to an article will be displayed
		CommentDAO dao=new CommentDAO();
		ccc
		List<Comment> a=dao.showCommentsByArticles(article);
		for(Comment s:a)
			System.out.println(s.getComments());
	
*/
//		CommentsService commentsService=new CommentsService();
//		Article article=new Article();
//		article.setTitle("");
//		try{
//		commentsService.serviceShowCommentsByArticles(article);
//	}
//			catch(ServiceException e){
//				e.printStackTrace();
//	
//			}
		CommentDAO dao=new CommentDAO();
		System.out.println(dao.list());
}}
