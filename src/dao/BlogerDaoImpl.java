package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Bloger;
import bean.Page;
import util.Pool;

public class BlogerDaoImpl implements BlogerDao{
     private static Pool pool = new Pool();
     private static Connection ct;
	@Override
	public Bloger getByName(String Name) {
		ct = pool.getConnec();
		String sql = "select * from Bloger where Name=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, Name);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return new Bloger(rs.getInt(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getTimestamp(5));
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
	
	
	public Bloger getById(int id) {
		ct = pool.getConnec();
		String sql = "select * from Bloger where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return new Bloger(rs.getInt(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getTimestamp(5));
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
	public List getAll() {
		ct = pool.getConnec();
		String sql = "select * from Bloger";
		List list = new ArrayList();
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Bloger(rs.getInt(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getTimestamp(5)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List getByPage(Page page) {
		ct = pool.getConnec();
		List list = new ArrayList();
		String sql = "select * from Bloger limit "+page.getBeginindex()+","+page.getEverycount();
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Bloger(rs.getInt(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getTimestamp(5)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount() {
		ct = pool.getConnec();
		String sql = "select count(*) from Bloger";
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
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
	public boolean delete(int id) {
		ct = pool.getConnec();
		String sql = "delete from Bloger where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
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
	public boolean update(Bloger bloger) {
		ct = pool.getConnec();
		String sql = "update Bloger set Name=?,Email=?,Tel=? where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, bloger.getName());
			psmt.setString(2, bloger.getEmail());
			psmt.setString(3, bloger.getTel());
			psmt.setInt(4,bloger.getId());
			psmt.executeUpdate();
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
