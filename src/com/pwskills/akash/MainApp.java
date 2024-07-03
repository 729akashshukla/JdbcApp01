package com.pwskills.akash;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.pwskills.utility.DBUtil;

public class MainApp {
	public static void main(String[] args) {
		
		Connection connection = null ;
		Statement statement = null;
		ResultSet resultset = null;
			
		try {	
			connection = DBUtil.getDBConnection();
					
			//2. Create a Statement Object
			statement =connection.createStatement();
			
			
			//3.Execute the query
			String SqlSelectQuery = "select sid,sname,sage,saddress from student";
			resultset =statement.executeQuery(SqlSelectQuery);
			
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
		
		 DBUtil.cleanUpResources(resultset, statement, connection);
			}
			
		}
}	
 


