package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class AccountRegisterDAO {
	
	//データベース情報
	final String jdbcId = "newUser";
	final String jdbcPass = "abc";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/docoTsubu?characterEncoding=UTF-8";
	
	public boolean accountRegister(User user) {
		try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){

			String sql  = "insert into userlist (id , name , pass ) values (? , ? ,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPass());
			
			int r = ps.executeUpdate();
			
			if(r !=  0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}
