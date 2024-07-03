package com.pwskills.utility;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBUtil {
	public static Connection getDBConnection()throws IOException,SQLException {
		FileInputStream fis =null;
		
		String fileInfo ="E:\\JdbcApp01\\src\\com\\pwskills\\properties\\database.properties";
		fis = new FileInputStream(fileInfo);
		Properties properties = new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		  //1.Establish connection
	    return DriverManager.getConnection(url,user,password);
		
	}
	
	public static void cleanUpResources(ResultSet resultset ,Statement statement,Connection connection) {
		//5.Close the resources
		
				// closing resultset 
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
				}
	}
}	
