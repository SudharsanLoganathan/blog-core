package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;



import com.blog.model.Article;
import com.blog.model.ArticleCatagory;
import com.blog.model.SeedCatagory;
import com.blog.util.ConnectionUtil;

public class ArticleCatagoryDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final ArticleDAO articleDAO,SeedCatagoryDAO seedCatagoryDAO) {
		final String sql = "insert into ARTICLE_CATAGORY (ARTICLE_ID,CATAGORY_ID) values (?,?) ";
		final Object[] params = {articleDAO.getArticleLastInsertedId(),seedCatagoryDAO.getCategoryLastInsertedId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void delete(final ArticleCatagory articleCatagory) {
		final String sql = "delete from ARTICLE_CATAGORY where ARTICLE_ID=?";
		final Object[] params = { articleCatagory.getArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(final ArticleCatagory articleCatagory) {
		final String sql = "update ARTICLE_CATAGORY set CATAGORY_ID=? where ARTICLE_ID=?";
		final Object[] params = {articleCatagory.getCatagoryId().getId(),articleCatagory.getArticleId().getId()};
		jdbcTemplate.update(sql, params);

	}
	public List<ArticleCatagory> list() {
		final String sql = "select ID,ARTICLE_ID,CATAGORY_ID from ARTICLE_CATAGORY";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);
	}
		static ArticleCatagory convert(final ResultSet rs) throws SQLException {
			ArticleCatagory articleCatagory = new ArticleCatagory();
			articleCatagory.setId(rs.getInt("ID"));
			Article article = new Article();
			article.setId(rs.getInt("ARTICLE_ID"));
			articleCatagory.setArticleId(article);
			SeedCatagory catagory = new SeedCatagory();
			catagory.setId(rs.getInt("CATAGORY_ID"));
			articleCatagory.setCatagoryId(catagory);;
			return articleCatagory;
		}
		
}
