package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountDAO {

	
	//データベース情報
		final String jdbcId = "newUser";
		final String jdbcPass = "abc";
		final String jdbcUrl = "jdbc:mysql://localhost:3306/docoTsubu?characterEncoding=UTF-8";
		
		public User findAccount(User user) {

			//戻り地の用意
			User returnUser = new User();
			
			try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){

				String sql  = "select * from userlist where id = ? and pass = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, user.getId());
				ps.setString(2, user.getPass());
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					returnUser.setId(rs.getString("id"));
					returnUser.setName(rs.getString("name"));
					returnUser.setPass(rs.getString("pass"));
				}else {
					return null;
				}
				
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
			
			return returnUser;
		}
}
