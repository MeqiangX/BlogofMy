package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

//数据库连接池类
public class Pool {
	 // private static Properties pr = new Properties();
      private static BasicDataSource datasource = new BasicDataSource();
      //获得连接池对象
      
      //静态代码块，只在类加载的时候调用创建堆，只加载一次，可以重复给对象用，适合连接池的创建,一次就好
      static {
    	  Properties pr = new Properties();
    	 try {
			//FileInputStream fs = new FileInputStream("src/DBconfig.properties");
    		//pr.load(fs);
    		 pr.load(Pool.class.getClassLoader().getResourceAsStream("DBconfig.properties"));
			//从输入流中加载配置文件
			
			//配置 四大参数
			datasource.setDriverClassName(pr.getProperty("driver"));
            datasource.setUrl(pr.getProperty("url"));
            datasource.setUsername(pr.getProperty("user"));
            datasource.setPassword(pr.getProperty("password"));
            
            
            
            //配置池参数  最小空闲连接数 最大连接数 最大等待时间
            datasource.setMinIdle(3);
            datasource.setMaxTotal(20);
            datasource.setMaxWaitMillis(1000);
            
    	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
      }
      
      //获得连接
      public static Connection getConnec() {
    	  Connection ct;  
    	  try {
			ct = datasource.getConnection();
			return ct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    
    	  return null;
    	  
      }
}
