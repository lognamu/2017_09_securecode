package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
			
	        //DB드라이버 로딩
			try {			
				Class.forName("com.mysql.jdbc.Driver");
				//Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url1 = new String();
			//연결작업
			String url = "jdbc:mysql://localhost:3306/hr";
			//String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "root";
			String pwd = "1111";
			
			//연결획득
			Connection conn = DriverManager.getConnection(url,user,pwd);
			if(conn != null){
				System.out.println("연결성공");
			}else{
				System.out.println("연결실패");
			}
			
			//명령처리객체 획득
			Statement stmt = conn.createStatement();
			
			//sql문 작성
			String sql = "select * from employees";
			
			//결과받기
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()){
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				int salary = rs.getInt("salary");
			
			}
			
			//역순으로 객체닫기
			rs.close();
			stmt.close();
			conn.close();
	}

}
