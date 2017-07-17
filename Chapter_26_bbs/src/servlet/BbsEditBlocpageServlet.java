package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;

@WebServlet("/bbs/editBlockpage.do")
public class BbsEditBlocpageServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int blockpage = Integer.parseInt(request.getParameter("blockpage"));
		Common.Bbs.BLOCKPAGE = blockpage;
		response.sendRedirect("/bbs/list.do");
	}

}