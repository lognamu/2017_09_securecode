package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnector {
	
	private static DBConnector single;
	DataSource ds;
	
	private DBConnector(){
		
		try {
			InitialContext ic = new InitialContext();
			Context ctx = (Context)ic.lookup("java:comp/env");
			ds = (DataSource)ctx.lookup("jdbc/mysql_web_programing");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static DBConnector getInstance(){
		if(single == null){
			single = new DBConnector();
		}
		
		return single;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
