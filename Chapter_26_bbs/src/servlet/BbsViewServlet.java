package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BbsDao;
import vo.BbsVo;

@WebServlet("/bbs/view.do")
public class BbsViewServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		BbsVo vo = BbsDao.getInstance().selectOne(idx);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/bbs/view.jsp").forward(request, response);
	}

}
