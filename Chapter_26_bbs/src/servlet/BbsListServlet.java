package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import dao.BbsDao;
import util.Paging;
import vo.BbsVo;

@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//----조건검색----
		String option = request.getParameter("option");
		String text = request.getParameter("text");
		
		//----조건검색----
		
		//----페이징----
		String searchParam = "";
		if(option != null){
			searchParam = "option="+option+"&text="+text;
		}
		int nowPage = 1;
		String page = request.getParameter("page");
		if(page != null && !page.isEmpty()){
			nowPage = Integer.parseInt(page);
		}
		int start = (nowPage - 1)* Common.Bbs.BLOCKLIST + 1;
		int end = start + Common.Bbs.BLOCKLIST - 1;
		//----페이징----
		
		//----조건검색----
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("option", option);
		map.put("text", text);
		//----조건검색----
		
		//----페이징----
		map.put("start", start);
		map.put("end", end);
		//----페이징----
		
		List<BbsVo> list = BbsDao.getInstance().selectList(map);
		//----페이징----
		int rowCount = BbsDao.getInstance().rowCount(map);
		//----페이징----
		
		request.setAttribute("list", list);
		request.setAttribute("option", option);
		request.setAttribute("text", text);
		//페이징

		String paging = Paging.getPaging("/bbs/list.do", nowPage, rowCount, 
										 Common.Bbs.BLOCKLIST, 
										 Common.Bbs.BLOCKPAGE, searchParam);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("/bbs/list.jsp").forward(request, response);
	}

}