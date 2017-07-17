package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbConnector;
import util.DbConnectorJNDI;

/**
 * Servlet implementation class JdbcServlet
 */
@WebServlet("/jdbc.do")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//DbConnector connector = DbConnector.getInstance();
			DbConnectorJNDI connector = DbConnectorJNDI.getInstance();
			
			//연결획득
			Connection conn = connector.getConnection();
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
			
			PrintWriter out = response.getWriter();
			
			while(rs.next()){
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				int salary = rs.getInt("salary");
				out.println(employee_id+"//"+first_name+"//"+salary);
			}
			
			//역순으로 객체닫기
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
