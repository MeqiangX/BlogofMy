package service;

import bean.User;
import dao.UserDaoImpl;

public class User_service {
     private UserDaoImpl udi = new UserDaoImpl();
     
     public boolean Login(User user) {
    	 return udi.Login(user);
     }
       
}
