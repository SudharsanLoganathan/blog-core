package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blog.model.Role;
import com.blog.util.ConnectionUtil;

@Repository
public class RoleDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	
	public void save(final Role role) {
		final String sql = "insert into ROLE(NAME) values (?) ";
		final Object[] params = {role.getName()};
		jdbcTemplate.update(sql, params);

	}

	
	public void delete(final Role role) {
		final String sql = "delete from ROLE where ID=?";
		final Object[] params = { role.getId() };
		jdbcTemplate.update(sql, params);

	}

	
	public void update(final Role role) {
		final String sql = "update ROLE set NAME=? where ID=?";
		final Object[] params = {role.getName(),role.getId()};
		jdbcTemplate.update(sql, params);

	}

	public List<Role> list() {
		final String sql = "select ID,NAME from ROLE";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));

	}

	
	static Role convert(final ResultSet rs) throws SQLException {
	Role role = new Role();
	role.setId(rs.getInt("ID"));
	role.setName(rs.getString("NAME"));
		return role;
	}
}
