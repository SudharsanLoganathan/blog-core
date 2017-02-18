package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blog.model.Article;
import com.blog.model.Comment;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

@Repository
public class CommentDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final Comment comments) {
		final String sql = "insert into COMMENTS(ARTICLE_ID,USER_ID,COMMENTS) values (?,?,?)";
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
		final String sql = "SELECT USER_DETAILS.`NAME`,ARTICLES.`TITLE`,COMMENTS.`COMMENTS` FROM ARTICLES JOIN USER_DETAILS JOIN COMMENTS ON ARTICLES.`ID`=COMMENTS.`ARTICLE_ID` AND USER_DETAILS.`ID`=COMMENTS.`USER_ID`";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);
	}
	static Comment convert(final ResultSet rs) throws SQLException {
		Comment comments = new Comment();
		//comments.setId(rs.getInt("ID"));
		Article article= new Article();
		UserDetail userDetail=new UserDetail();
		userDetail.setName(rs.getString("NAME"));
		article.setTitle(rs.getString("TITLE"));
		comments.setUserId(userDetail);
		comments.setArticleId(article);
		comments.setComments(rs.getString("COMMENTS"));
		return comments;
	}
	public List<Comment> showCommentsByArticles(Article article)
	{
		String sql="SELECT ARTICLES.`TITLE`,COMMENTS.`COMMENTS` FROM COMMENTS JOIN ARTICLES ON COMMENTS.`ARTICLE_ID`=ARTICLES.`ID` WHERE ARTICLES.`TITLE`=?";
		Object[] params={article.getTitle()};
		return jdbcTemplate.query(sql,params,(rs,rowNum)-> convertComments(rs));
	}
	static Comment convertComments(final ResultSet rs) throws SQLException {
		Comment comment=new Comment();
		Article article=new Article();
		article.setTitle(rs.getString("TITLE"));
		comment.setArticleId(article);
		comment.setComments(rs.getString("COMMENTS"));
		return comment;
	}
}
