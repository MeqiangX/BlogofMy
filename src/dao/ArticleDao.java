package dao;

import java.util.List;

import bean.Article;
import bean.Page;

public interface ArticleDao {
     public List getArtsByU_id(int u_id);
     
     public Article getArtById(int u_id,int a_id);
     
     public int getMaxA_Id(int u_id);
     
     public boolean save(Article article);
     
     public List<Article> getByPage(Page page,int u_id);
     
     public int getAll(int u_id);
}
