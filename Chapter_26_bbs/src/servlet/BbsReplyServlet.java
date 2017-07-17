package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import vo.BbsVo;

@WebServlet("/bbs/reply.do")
public class BbsReplyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		BbsVo vo = BbsDao.getInstance().selectOne(idx);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/bbs/reply.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BbsVo baseVo = BbsDao.getInstance().selectOne(idx);
		
		BbsVo vo = new BbsVo();
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setIp(request.getRemoteAddr());
		vo.setRef(baseVo.getRef());
		vo.setStep(baseVo.getStep() + 1);
		vo.setDepth(baseVo.getDepth() + 1);
		
		BbsDao.getInstance().updateStep(baseVo);
		BbsDao.getInstance().reply(vo);
		response.sendRedirect("/bbs/list.do");

	}

}