package service;

import java.util.List;

import bean.Article;
import bean.Page;
import dao.ArticleDaoImpl;

public class Article_service {
    private ArticleDaoImpl adi = new ArticleDaoImpl();
    
    public List<Article> getArtsByU_id(int u_id) {
    	return adi.getArtsByU_id(u_id);
    }
    
    public Article getArtById(int u_id,int a_id) {
    	return adi.getArtById(u_id, a_id);
    }
    
    public int getMaxA_id(int u_id) {
    	return adi.getMaxA_Id(u_id);
    }
    
    public boolean save(Article article) {
    	return adi.save(article);
    }
    
    public List<Article> getByPage(Page page,int u_id){
    	return adi.getByPage(page, u_id);
    }
    
    public int getAll(int u_id) {
    	return adi.getAll(u_id);
    }
}
