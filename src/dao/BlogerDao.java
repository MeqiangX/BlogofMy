package dao;

import java.util.List;

import bean.Bloger;
import bean.Page;

public interface BlogerDao {
    public Bloger getByName(String Name);
    
    public Bloger getById(int id);
    
    public int getCount();
    
    public List getAll();
    
    public List getByPage(Page page);
    
    public boolean delete(int id);
    
    public boolean update(Bloger bloger);
    

    
}
