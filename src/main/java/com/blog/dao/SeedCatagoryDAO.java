package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blog.model.Article;
import com.blog.model.SeedCatagory;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

@Repository
public class SeedCatagoryDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final SeedCatagory catagory) {
		final String sql = "insert into SEED_CATAGORY(CATAGORY,USER_ID) values (?,?) ";
		final Object[] params = {catagory.getCatagory(),catagory.getUserId().getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void delete(final SeedCatagory catagory) {
		final String sql = "delete from SEED_CATAGORY where ID=?";
		final Object[] params = { catagory.getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(final SeedCatagory catagory) {
		final String sql = "update SEED_CATAGORY set CATAGORY=? where USER_ID=?";
		final Object[] params = {catagory.getCatagory(),catagory.getUserId().getId()};
		jdbcTemplate.update(sql, params);

	}
	public List<SeedCatagory> list() {
		final String sql = "select ID,CATEGORY,USER_ID from SEED_CATAGORY";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);

	}

	static SeedCatagory convert(final ResultSet rs) throws SQLException {
		SeedCatagory catagory = new SeedCatagory();
		catagory.setId(rs.getInt("ID"));
		catagory.setCatagory(rs.getString("CATAGORY"));
		UserDetail user= new UserDetail();
		user.setId(rs.getInt("USER_ID"));
		catagory.setUserId(user);
		return catagory;
	}
	public Integer getCategoryLastInsertedId()
	{
		String sql="select ifnull((select ID from seed_catagory order by ID DESC limit 1 ),null) as ID";
		return jdbcTemplate.queryForObject(sql,(rs,rowNum)->
		{
			return rs.getInt("ID");
		});
	}
	
	public List<Article> getArticlesByCatagory(SeedCatagory seedCatagory)
	{
		String sql="SELECT ARTICLES.`TITLE`,ARTICLES.`CONTENT` FROM ARTICLES JOIN ARTICLE_CATAGORY ON ARTICLE_CATAGORY.`ARTICLE_ID`=ARTICLES.`ID`JOIN SEED_CATAGORY ON ARTICLE_CATAGORY.`CATAGORY_ID`=SEED_CATAGORY.`ID` WHERE SEED_CATAGORY.`CATAGORY`=?";
		Object[] params={seedCatagory.getCatagory()};
		return jdbcTemplate.query(sql,params,(rs,rowNum)-> convertArticles(rs));
		
	}
	static Article convertArticles(final ResultSet rs) throws SQLException {
		Article article=new Article();
		article.setTitle(rs.getString("TITLE"));
		article.setContent(rs.getString("CONTENT"));
		return article;
	}
}
