package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {	
	
	private static DbConnector single = null;

	private DbConnector() {
	}

	public static DbConnector getInstance() {
		if (single == null) {
			single = new DbConnector();
		}

		return single;
	}
	
	
	static{
		//DB드라이버 로딩
		try {			
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		//연결작업
		String url = "jdbc:mysql://localhost:3306/hr";
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "root";
		String pwd = "1111";
		
		try {
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
