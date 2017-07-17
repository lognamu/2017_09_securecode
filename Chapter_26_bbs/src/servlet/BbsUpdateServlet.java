package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import vo.BbsVo;

@WebServlet("/bbs/update.do")
public class BbsUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		BbsVo vo = BbsDao.getInstance().selectOne(idx);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/bbs/update.jsp").forward(request, response);;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BbsVo vo = new BbsVo();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		BbsDao.getInstance().update(vo);
		response.sendRedirect("/bbs/view.do?idx="+idx);
	}

}