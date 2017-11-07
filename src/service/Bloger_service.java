package service;

import java.util.List;

import bean.Bloger;
import bean.Page;
import dao.BlogerDaoImpl;

public class Bloger_service {
	private static BlogerDaoImpl bdi = new BlogerDaoImpl();
   
	public Bloger getByName(String Name) {
		return bdi.getByName(Name);
	}
	
	public Bloger getById(int id) {
		return bdi.getById(id);
	}
	
	public int getCount() {
		return bdi.getCount();
	}
	
	public List getAll() {
		return bdi.getAll();
	}
	
	public List getByPage(Page page) {
		return bdi.getByPage(page);
	}
	
	public boolean delete(int id) {
		return bdi.delete(id);
	}
	
	public boolean update(Bloger bloger) {
		return bdi.update(bloger);
	}
}
