package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DB_Testing {
	
	private Connection connection;
 
  @BeforeClass
  public void beforeClass() throws Exception {
      // Kết nối tới DB (MySQL làm ví dụ)
	  //String url = "jdbc:mysql://localhost:3306/demo_db";

      String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12795346";
      String user = "sql12795346";
      String password = "gYNu4fUD21";

      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connected to database");
  }
  
  @Test
  public void verifyAge() throws SQLException {
	  
	  // SELECT age FROM sinhvien WHERE name='Tran Thi B';	  
      String query = "SELECT age FROM sinhvien WHERE name='Tran Thi B';";
      Statement stmt = connection.createStatement();
      ResultSet result = stmt.executeQuery(query);
      
      if (result.next()) {                          // di chuyển con trỏ tới row đầu tiên
    	    int age = result.getInt("age");         // Chuyen con tro qua cot age
      		Assert.assertEquals(age, 35, "Kiểm tra Age đúng không ? ") ;
      		}
  		}
  

  @AfterClass
  public void afterClass() throws Exception {
	  if (connection != null && !connection.isClosed()) {
          connection.close();
          System.out.println("Disconnected from database");
      }
  }
}
