package com.blog.service;

import java.util.List;

import com.blog.dao.ArticleDAO;
import com.blog.exception.ServiceException;
import com.blog.exception.UserInvalidException;
import com.blog.model.Article;
import com.blog.model.UserDetail;

public class TestArticleService {
	public static void main(String[] args) throws UserInvalidException {
	/*	//Post an Article
		Article article = new Article();
		SeedCatagory seedCatagory=new SeedCatagory();
		UserDetail userDetail=new UserDetail();
		userDetail.setId(1);
		article.setUserId(userDetail);
		article.setTitle("Javaservlet");
		article.setContent("Basics");
		seedCatagory.setCatagory("Java");
		seedCatagory.setUserId(userDetail);
		ArticleDAO articleDAO=new ArticleDAO();
		SeedCatagoryDAO seedCatagoryDAO=new SeedCatagoryDAO();
		ArticleService articleService = new ArticleService();
		articleService.postArticleService(article,seedCatagory,articleDAO,seedCatagoryDAO );
		*/
 
		/*//User can view the articles published by him
		ArticleDAO dao=new ArticleDAO();
		UserDetail userDetail=new UserDetail();
		userDetail.setName("sudhar");
		List<Article> a=dao.getArticlesPublishedByUser(userDetail);
		for(Article s:a)
			System.out.println(s.getTitle()+" "+s.getContent());
	
	*/
		ArticleService articleService=new ArticleService();
		UserDetail userDetail=new UserDetail();
		userDetail.setId(7);

			articleService.serviceGetArticlesPublishedByUser(userDetail);
			
		
}
}
