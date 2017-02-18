package com.blog.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blog.config.AppConfig;
import com.blog.exception.ServiceException;
import com.blog.model.Article;
import com.blog.model.UserDetail;
import com.blog.service.ArticleService;

public class TestArticleDAO {

	public static void main(String[] args) throws ServiceException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ArticleService articleServiceObj  = ctx.getBean(ArticleService.class);
		Article article=new Article();
		UserDetail user=new UserDetail();
		
		user.setId(6);
		System.out.println(articleServiceObj.serviceGetArticlesPublishedByUser(user));
		/*user.setId(12);
		article.setUserId(user);
		article.setTitle("DB");
		article.setContent("Backend");
		articleServiceObj.serviceSave(article);*/
		/*article.setId(1);
		user.setId(2);
		article.setUserId(user);
		article.setTitle("C");
		article.setContent("new");*/
	 
		//ArticleDAO dao=new ArticleDAO();
		//dao.save(article);
		//System.out.println(dao.list());

	}

}
