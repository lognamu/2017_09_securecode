package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;

@WebServlet("/bbs/editBlocklist.do")
public class BbsEditBlocklistServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int blocklist = Integer.parseInt(request.getParameter("blocklist"));
		Common.Bbs.BLOCKLIST = blocklist;
		response.sendRedirect("/bbs/list.do");
	}

}