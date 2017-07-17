package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장위치
		//String path = "c:/upload";
		String webPath = "/upload/";
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath(webPath);
		System.out.println(realPath);
		int maxSize = 1024*1024*10;
		
		MultipartRequest mr = new MultipartRequest(
				request, 
				realPath, 
				maxSize, 
				"utf-8", 
				new DefaultFileRenamePolicy());
		String title = mr.getParameter("title");
		System.out.println(title);
		File file = mr.getFile("photo");
		String fileName = "no exist";
		if(file != null){
			fileName = file.getName();
		}
		
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
