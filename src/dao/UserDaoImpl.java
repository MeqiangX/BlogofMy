package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import util.Pool;

public class UserDaoImpl implements UserDao{
     private Pool pool = new Pool();
     private Connection ct;
	@Override
	public boolean Login(User user) {
	    ct = pool.getConnec();
	    String sql = "select * from Login where user_name=? and password=?";
	    
	    try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, user.getUser_name());
			psmt.setString(2, user.getPassword());
			
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) 
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
		return false;
	}
   
}
