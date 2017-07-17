package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import vo.CommentVo;

@WebServlet("/comment/insert.do")
public class CommentInsertServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		CommentVo vo = new CommentVo();
		vo.setB_idx(idx);
		vo.setName(name);
		vo.setContent(content);
		
		CommentDao.getInstance().insert(vo);
		response.sendRedirect("/bbs/view.do?idx="+idx);
	}

}