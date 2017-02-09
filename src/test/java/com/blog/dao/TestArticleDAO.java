package com.blog.dao;

import com.blog.model.Article;
import com.blog.model.UserDetail;

public class TestArticleDAO {

	public static void main(String[] args) {
		Article article=new Article();
		UserDetail user=new UserDetail();
		/*article.setId(1);
		user.setId(2);
		article.setUserId(user);
		article.setTitle("C");
		article.setContent("new");*/
	 
		ArticleDAO dao=new ArticleDAO();
		//dao.save(article);
		System.out.println(dao.list());

	}

}
