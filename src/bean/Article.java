package bean;

import java.sql.Date;

public class Article {
     private int a_id;
     private String Title;
     private String describe;
     private String content;
     private Date date;
     private int u_id;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(int a_id, String title, String describe, String content,Date date, int u_id) {
		super();
		this.a_id = a_id;
		Title = title;
		this.describe = describe;
		this.content = content;
		this.date = date;
		this.u_id = u_id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
     
}
