package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import vo.BbsVo;

@WebServlet("/bbs/insert.do")
public class BbsInsertServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/bbs/insert.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BbsVo vo = new BbsVo();
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setIp(request.getRemoteAddr());
		BbsDao.getInstance().insert(vo);
		response.sendRedirect("/bbs/list.do");
	}


}
