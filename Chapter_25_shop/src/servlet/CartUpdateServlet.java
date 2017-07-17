package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

@WebServlet("/cart/update.do")
public class CartUpdateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int count = Integer.parseInt(request.getParameter("count"));
		CartVo vo = new CartVo();
		vo.setIdx(idx);
		vo.setCount(count);
		CartDao.getInstance().update(vo);
		response.sendRedirect("/cart/list.do");
	}

}
