package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

@WebServlet("/cart/list.do")
public class CartListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int u_idx = 1;
		List<CartVo> list = CartDao.getInstance().selectList(u_idx);
		int totalAmount = 0;
		for(CartVo vo : list){
			totalAmount += vo.getCount() * vo.getPvo().getPrice_sale();
		}
		request.setAttribute("list", list);
		request.setAttribute("totalAmount", totalAmount);
		request.getRequestDispatcher("/cart/list.jsp").forward(request, response);
	}

}
