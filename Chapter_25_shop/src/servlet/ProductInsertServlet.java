package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dao.ProductDao;
import vo.ProductVo;

@WebServlet("/product/insert.do")
public class ProductInsertServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String realPath = request.getServletContext().getRealPath("/images");
		int size = 1024*1024*10;
		MultipartRequest mr = new MultipartRequest(request, realPath, size, "utf-8");
		ProductVo vo = new ProductVo();
		vo.setCategory(mr.getParameter("category"));
		vo.setModel(mr.getParameter("model"));
		vo.setManufacturer(mr.getParameter("manufacturer"));
		vo.setPrice_ori(Integer.parseInt(mr.getParameter("price_ori")));
		vo.setPrice_sale(Integer.parseInt(mr.getParameter("price_sale")));
		vo.setContent(mr.getParameter("content"));
		
		File image_s = mr.getFile("image_s");
		vo.setImage_s(image_s.getName());
		
		File image_l = mr.getFile("image_l");
		vo.setImage_l(image_l.getName());
		
		ProductDao.getInstance().insert(vo);
		
		response.sendRedirect("/product/list.do");
	}

}