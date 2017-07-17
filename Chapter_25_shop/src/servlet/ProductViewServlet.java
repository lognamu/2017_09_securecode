package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

@WebServlet("/product/view.do")
public class ProductViewServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idx = request.getParameter("idx");
		ProductVo vo = ProductDao.getInstance().selectOne(idx);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/product/view.jsp").forward(request, response);
	}

}