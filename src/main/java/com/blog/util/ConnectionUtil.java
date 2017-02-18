package com.blog.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class ConnectionUtil {
	private ConnectionUtil()
	{
		
	}
	
	public static DataSource getDataSource() {
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/blog");
		ds.setUsername("root");
		ds.setPassword("sudharsan");
		return ds;
	}
	public static JdbcTemplate getJdbcTemplate()

	{
		final JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
}
