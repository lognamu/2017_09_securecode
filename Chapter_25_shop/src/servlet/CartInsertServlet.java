package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

@WebServlet("/cart/insert.do")
public class CartInsertServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int u_idx = Integer.parseInt(request.getParameter("u_idx"));
		
		CartVo vo = new CartVo();
		vo.setP_idx(p_idx);
		vo.setU_idx(u_idx);
		CartVo resVo = CartDao.getInstance().selectOne(vo);
		String result = "no";
		if(resVo == null){
			result = "yes";
			CartDao.getInstance().insert(vo);
		}
		response.getWriter().print(result);
	}

}