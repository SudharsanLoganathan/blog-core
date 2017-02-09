package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.blog.model.Article;
import com.blog.model.RatingGiven;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

public class RatingGivenDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final RatingGiven ratingGiven) {
		final String sql = "insert into RATINGS_GIVEN(USER_ID,ARTICLE_ID,RATINGS) values (?,?,?) ";
		final Object[] params = {ratingGiven.getUserId().getId(),ratingGiven.getArticleId().getId(),ratingGiven.getRatings()};
		jdbcTemplate.update(sql, params);

	}
	
	public void delete(final RatingGiven ratingGiven) {
		final String sql = "delete from RATINGS_GIVEN where ARTICLE_ID=?";
		final Object[] params = { ratingGiven.getArticleId().getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(final RatingGiven ratingGiven) {
		final String sql = "update RATINGS_GIVEN set RATINGS=? where ARTICLE_ID=?";
		final Object[] params = {ratingGiven.getRatings(),ratingGiven.getArticleId().getId()};
		jdbcTemplate.update(sql, params);

	}
	public List<RatingGiven> list() {
		final String sql = "Select ID,USER_ID,ARTICLE_ID,RATINGS,LIKES from RATINGS_GIVEN";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
	);

	}

	
	static RatingGiven convert(final ResultSet rs) throws SQLException {
		RatingGiven ratingGiven = new RatingGiven();
		ratingGiven.setId(rs.getInt("ID"));
		UserDetail user = new UserDetail();
		user.setId(rs.getInt("USER_ID"));
		ratingGiven.setUserId(user);
		Article article = new Article();
		article.setId(rs.getInt("ARTICLE_ID"));
		ratingGiven.setArticleId(article);
		ratingGiven.setRatings(rs.getInt("RATINGS"));
		ratingGiven.setLike(rs.getBoolean("LIKES"));
		return ratingGiven;
	}
}
