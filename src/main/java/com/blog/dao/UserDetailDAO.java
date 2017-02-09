package com.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.blog.model.Role;
import com.blog.model.UserDetail;
import com.blog.util.ConnectionUtil;

public class UserDetailDAO {
     JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final UserDetail user) {
		final String sql = "insert into USER_DETAILS(NAME,PASSWORD,EMAIL_ID) values (?,?,?) ";
		final Object[] params = {user.getName(),user.getPassword(),user.getEmailId() };
		jdbcTemplate.update(sql, params);
	}
	 
		public void delete(final UserDetail user) {
			final String sql = "delete from USER_DETAILS where ID=?";
			final Object[] params = { user.getId() };
			jdbcTemplate.update(sql, params);

		}
		
		public void update(final UserDetail user) {
			final String sql = "update USER_DETAILS set PASSWORD=? where NAME=?";
			final Object[] params = {user.getPassword(),user.getName() };
			jdbcTemplate.update(sql, params);

}
		public List<UserDetail> list() {
			final String sql = "select ID,NAME,PASSWORD,EMAIL_ID,ROLE_ID from USER_DETAILS";
			return jdbcTemplate.query(sql, (rs, rowNum) -> 
				 convert(rs)
		);
		}
		static UserDetail convert(final ResultSet rs) throws SQLException {
			UserDetail user = new UserDetail();
			Role role=new Role();
			user.setId(rs.getInt("ID"));
			role.setId(rs.getInt("ID"));
			user.setName(rs.getString("NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setEmailId(rs.getString("EMAIL_ID"));
			user.setRoleId(role);
			return user;
		}
		public void login(final UserDetail user) {
				final String sql = "SELECT IFNULL((SELECT 1 FROM USER_DETAI WHERE NAME=? AND PASSWORD=?),NULL);";
				final Object[] params = {user.getName(),user.getPassword()};
			Integer value=jdbcTemplate.queryForObject(sql,params,Integer.class);
			if(value!=null){
            System.out.print("Login Successfull");
        		  }
			else
			{
				System.out.print("Invalid UserName/password");			
				}
		}
		
		public List<UserDetail> listParticular(int id) {
			final String sql = "select NAME,PASSWORD,EMAIL_ID from USER_DETAILS WHERE ID=?";
			//Object[] params={id};
			return jdbcTemplate.query(sql, (rs, rowNum) ->{
				UserDetail user = new UserDetail();
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmailId(rs.getString("EMAIL_ID"));
				return user;
			
			});
		}
		public UserDetail getIdByEI(String emailid){
			String sql="SELECT ID FROM USER_DETAILS WHERE EMAIL_ID=?";
			Object[] params={emailid};
			return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) ->{
				UserDetail user = new UserDetail();
				user.setId(rs.getInt("ID"));
				return user;
		});
		}
			public UserDetail getIdByPW(String password){
				String sql="SELECT ID FROM USER_DETAILS WHERE PASSWORD=?";
				Object[] params={password};
				return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) ->{
					UserDetail user = new UserDetail();
					user.setId(rs.getInt("ID"));
					return user;
			});
			}
				public void checkUser(Integer i , Integer j ) {
					if (i == j) {
						
					} 
			
}
}

		
