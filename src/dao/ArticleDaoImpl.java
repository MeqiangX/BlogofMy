package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.Page;
import util.Pool;

public class ArticleDaoImpl implements ArticleDao{
     private static Pool pool = new Pool();
     private static Connection ct;
	
	public List<Article> getArtsByU_id(int u_id) {
		// TODO Auto-generated method stub
		ct = pool.getConnec();
		String sql = "select * from article where u_id=?";
		List list = new ArrayList();
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, u_id);
			ResultSet rs = psmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)
						,rs.getDate(5),rs.getInt(6)));
			}
			return list;
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
		
		return null;
	}

	@Override
	public Article getArtById(int u_id, int a_id) {
		ct = pool.getConnec();
		String sql = "select * from article where u_id=? and a_id=?";

		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, u_id);
			psmt.setInt(2, a_id);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return new Article(rs.getInt(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getDate(5),rs.getInt(6));
			}
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
		
	   return null;
	}

	@Override
	public int getMaxA_Id(int u_id) {
		ct = pool.getConnec();
		String sql = "select MAX(a_id) from article where u_id=?";
		//获取最大的u_id用户下面的最大a_id;
		
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, u_id);
			ResultSet rs = psmt.executeQuery();
			
			
			if (rs.next()) {
				return rs.getInt(1);
			}
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
		return 0;
	}

	@Override
	public boolean save(Article article) {
		ct = pool.getConnec();
		String sql = "insert into article value(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, article.getA_id());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getDescribe());
			psmt.setString(4, article.getContent());
			psmt.setDate(5,article.getDate());
			psmt.setInt(6, article.getU_id());
			
			//boolean tip = psmt.execute();
			//System.out.println("tip="+tip);
			
			//1.ResultSet res = psmt.getResultSet();
			//2.int res = psmt.getUpdateCount();
			//execute()方法 返回的是第一个执行结果的形式，如果是结果集 ,如1、 则返回true
			//如果返回执行影响的行数，如2、，则返回false;
			
			//所以跟新操作还是用update 返回受影响的行数
			
			int count = psmt.executeUpdate();
			if (count > 0)
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

	@Override
	public List<Article> getByPage(Page page,int u_id) {
		ct = pool.getConnec();
	
		String sql = "select * from article where u_id=? limit "+page.getBeginindex() + "," + page.getEverycount();
		List<Article> list = new ArrayList();
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, u_id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getDate(5),rs.getInt(6)));
				
			}
			return list;
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
		
		return null;
	}

	@Override
	public int getAll(int u_id) {
		ct = pool.getConnec();
		String sql = "select count(*) from article where u_id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, u_id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
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
		return 0;
	}

}
