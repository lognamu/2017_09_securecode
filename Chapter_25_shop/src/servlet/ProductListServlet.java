package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import vo.ProductVo;

@WebServlet("/product/list.do")
public class ProductListServlet extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		
		if(category == null){
			category = "com001";
		}
		
		List<ProductVo> list = ProductDao.getInstance().selectList(category);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/product/list.jsp").forward(request, response);
	}

}
