package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;

/**
 * Servlet implementation class PhotoDeleteServlet
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		String dir = request.getParameter("dir");
		String filename = request.getParameter("filename");
		//데이터베이스에서 해당 튜플제거
		PhotoDao.getInstance().delete(Integer.parseInt(idx));
		//upload폴더에서 사진 삭제
		String fullpath = request.getServletContext().getRealPath(dir);
		String fullpathname = String.format("%s/%s", fullpath, filename);
		File photo = new File(fullpathname);
		photo.delete();
		response.sendRedirect("list.do");
	}

}
