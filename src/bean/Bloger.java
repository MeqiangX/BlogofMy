package bean;

import java.sql.Timestamp;

public class Bloger {
   private int id;
   private String Name;
   private String Email;
   private String Tel;
   private Timestamp date;
   
   public Bloger() {}
   
   
public Bloger(int id, String name, String email, String tel, Timestamp date) {
	super();
	this.id = id;
	Name = name;
	Email = email;
	Tel = tel;
	this.date = date;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getTel() {
	return Tel;
}
public void setTel(String tel) {
	Tel = tel;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
   
   
}
