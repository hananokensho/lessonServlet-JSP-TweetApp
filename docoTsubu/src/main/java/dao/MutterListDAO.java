package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;
import model.User;

public class MutterListDAO {
	//データベース情報
			final String jdbcId = "newUser";
			final String jdbcPass = "abc";
			final String jdbcUrl = "jdbc:mysql://localhost:3306/docoTsubu?characterEncoding=UTF-8";
			
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){
			//SQL文を用意
			String sql = "select id , name , text from mutter order by id desc";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id,name,text);
				mutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}
	
	public List<Mutter> findAllMyMutterList(User loginUser){
		List<Mutter> myMutterList = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){
			//SQL文を用意
			String sql = "select id , name , text from mutter where name = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, loginUser.getName());
			
			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id,name,text);
				myMutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return myMutterList;
	}
	
	public boolean deleteMutter(String id){
		try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){
			//SQL文を用意
			String sql = "delete from mutter where id = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, id);
			//SELECT文を実行
			int num = pStmt.executeUpdate();
			if(num != 1) {
				return false;
			}else {
				return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean mutterRegister(Mutter mutter) {
		
		try(Connection con = DriverManager.getConnection(jdbcUrl,jdbcId,jdbcPass)){

			String sql  = "insert into mutter ( name , text ) values ( ? ,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, mutter.getUserName());
			ps.setString(2, mutter.getText());

			//insert文を実行
			int result = ps.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
