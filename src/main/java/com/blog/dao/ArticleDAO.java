package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blog.model.Article;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

@Repository
public class ArticleDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final Article article) {
		final String sql = "insert into ARTICLES(USER_ID,TITLE,CONTENT) values (?,?,?)";
		final Object[] params = {article.getUserId().getId(),article.getTitle(),article.getContent()};
		jdbcTemplate.update(sql, params);
	}
	
	public void delete(final Article article) {
		final String sql = "UPDATE ARTICLES SET ACTIVE=0 WHERE ID=?";
		final Object[] params = { article.getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(final Article article) {
		final String sql = "update ARTICLES set TITLE=?,CONTENT=? where ID=?";
		final Object[] params = {article.getTitle(),article.getContent(),article.getId() };
		jdbcTemplate.update(sql, params);

	}
	public List<Article> list() {
		final String sql = "SELECT ARTICLES.`ID`,NAME,TITLE,CONTENT,CREATED_DATE,MODIFIED_DATE FROM ARTICLES JOIN USER_DETAILS ON ARTICLES.`USER_ID`=USER_DETAILS.`ID` WHERE ARTICLES.`ACTIVE`=1";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);

	}
	
	static Article convert(final ResultSet rs) throws SQLException {
		Article article = new Article();
		article.setId(rs.getInt("ID"));
		UserDetail user=new UserDetail();
		user.setName(rs.getString("NAME"));
		article.setUserId(user);
		article.setTitle(rs.getString("TITLE"));
		article.setContent(rs.getString("CONTENT"));
		article.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
		article.setModifiedDate(rs.getTimestamp("MODIFIED_DATE").toLocalDateTime());
		return article;
	}
	public Integer getArticleLastInsertedId()
	{
		String sql="select ifnull((select ID from articles order by ID DESC limit 1 ),null) as ID";
		return jdbcTemplate.queryForObject(sql,(rs,rowNum)->
		{
			return rs.getInt("ID");
		});
	}

	public List<Article> getArticlesPublishedByUser(UserDetail userDetail)
	{
		String sql="SELECT ID,TITLE,CONTENT,CREATED_DATE,MODIFIED_DATE FROM ARTICLES WHERE ARTICLES.`USER_ID`=? AND ACTIVE=1";
		Object[] params={userDetail.getId()};
		return jdbcTemplate.query(sql, params,(rs,rowNum)-> convertArticles(rs));
	}
	static Article convertArticles(final ResultSet rs) throws SQLException {
		Article article=new Article();
		article.setId(rs.getInt("ID"));
		article.setTitle(rs.getString("TITLE"));
		article.setContent(rs.getString("CONTENT"));
		article.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
		article.setModifiedDate(rs.getTimestamp("MODIFIED_DATE").toLocalDateTime());
		return article;
	}
	public UserDetail getEmailByArticleId(int articleId){
		String sql="SELECT USER_DETAILS.`EMAIL_ID` FROM USER_DETAILS JOIN ARTICLES ON USER_DETAILS.`ID`=ARTICLES.`USER_ID` WHERE ARTICLES.`ID`=?";
		Object[] params={articleId};
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) ->{
			UserDetail userDetail=new UserDetail();
			userDetail.setEmailId(rs.getString("EMAIL_ID"));
			return userDetail;
	});
	}
}
