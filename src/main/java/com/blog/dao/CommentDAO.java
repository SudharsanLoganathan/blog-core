package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

public class CommentDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final Comment comments) {
		final String sql = "insert into COMMENTS(ARTICLE_ID,USER_ID,COMMENTS) values (?,?,?) ";
		final Object[] params = {comments.getArticleId().getId(),comments.getUserId().getId(),comments.getComments()};
		jdbcTemplate.update(sql, params);

	}
	
	public void delete(final Comment comments) {
		final String sql = "delete from COMMENTS where ARTICLE_ID=?";
		final Object[] params = {comments.getArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(final Comment comments) {
		final String sql = "update COMMENTS set COMMENTS=? where ARTICLE_ID=?";
		final Object[] params = {comments.getComments(),comments.getArticleId().getId()};
		jdbcTemplate.update(sql, params);

	}
	public List<Comment> list() {
		final String sql = "select ID,ARTICLE_ID,USER_ID,COMMENTS from COMMENTS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);

	}
	static Comment convert(final ResultSet rs) throws SQLException {
		Comment comments = new Comment();
		comments.setId(rs.getInt("ID"));
		Article article= new Article();
		article.setId(rs.getInt("ARTICLE_ID"));
		comments.setArticleId(article);
		UserDetail user= new UserDetail();
		user.setId(rs.getInt("USER_ID"));
		comments.setUserId(user);
		comments.setComments(rs.getString("COMMENTS"));
		return comments;
	}
	public List<Comment> showCommentsByArticles(Article article)
	{
		String sql="SELECT COMMENTS.`COMMENTS` FROM COMMENTS JOIN ARTICLES ON COMMENTS.`ARTICLE_ID`=ARTICLES.`ID` WHERE ARTICLES.`TITLE`=?";
		Object[] params={article.getTitle()};
		return jdbcTemplate.query(sql,params,(rs,rowNum)-> convertComments(rs));
	}
	static Comment convertComments(final ResultSet rs) throws SQLException {
		Comment comment=new Comment();
		comment.setComments(rs.getString("COMMENTS"));
		return comment;
	}
}
