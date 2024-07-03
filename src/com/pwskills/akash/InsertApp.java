package com.pwskills.akash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.pwskills.utility.DBUtil;

public class InsertApp {

	private static final String SQLINSERT_QUERY = "insert into student values(1,'akash',23,'IND')";

	public static void main(String[] args) {
		
		// Resource used
		Connection connection = null;
		Statement statement = null;
		int rowCount=0;
		try {
			connection =DBUtil.getDBConnection();
			
			if(connection!=null)
				statement = connection.createStatement();
			if(statement!=null)
				rowCount = statement.executeUpdate(SQLINSERT_QUERY);
			if(rowCount==0)
				System.out.println("Failure in insertion......");
			else
				System.out.println("Record inserted sucessfully......");
				
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}

}
