package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoCheckPwdServlet
 */
@WebServlet("/photo/checkPwd.do")
public class PhotoCheckPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		String userPwd = request.getParameter("userPwd");
		PhotoVo vo = PhotoDao.getInstance().selectOne(Integer.parseInt(idx));
		String realPwd = vo.getPwd();
		if(realPwd.equals(userPwd)){
			response.getWriter().write("correct");
		}else{
			response.getWriter().write("incorrect");
		}
	}

}
