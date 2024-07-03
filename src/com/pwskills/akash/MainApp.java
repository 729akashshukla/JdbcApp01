package com.pwskills.akash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainApp {
	

	public static void main(String[] args) {
		
		Connection connection = null ;
		Statement statement = null;
		ResultSet resultset = null;
		FileInputStream fis =null;
			
		try {
			fis = new FileInputStream("E:\\JdbcApp01\\src\\com\\pwskills\\properties\\database.properties");
			Properties properties = new Properties();
			properties.load(fis);
			
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
		    //1.establish connection
		    connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connection establishesd foe ::"+url);
			System.out.println("Connectio ::"+connection.getClass().getName());
			
			//2. Create a Statement Object
			statement =connection.createStatement();
			System.out.println("\n Statement Object created...");
			System.out.println("Statement ::"+statement.getClass().getName());
			
			//3.Execute the query
			String SqlSelectQuery = "select sid,sname,sage,saddress from student";
			resultset =statement.executeQuery(SqlSelectQuery);
			System.out.println("\n Result Object created...");
			System.out.println("ResultSet ::"+ resultset.getClass().getName());
			
			//4.Process the result
			while(resultset.next()) {
				int sid = resultset.getInt(1);
				String sname = resultset.getString(2);
				int sage = resultset.getInt(3);
				String saddresss = resultset.getString(4);
				System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddresss);
				
			}
			
			
			
	} catch (SQLException e){
		e.printStackTrace();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}catch (Exception e){
		e.printStackTrace();
	}finally {
		//5.Close the resources
		
		// closing Resultset 
		if(resultset != null) {
			try {
			resultset.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			// closing statement
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// closing connection
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			// closing File Input Stream
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			
		
	}
		

}
}
}
