package net.board.wb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;
import net.user.member.db.WRMatchDAO;

public class WBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		int spage =1;
		String page=request.getParameter("page");
		
		if(page!=null) {
			spage=Integer.parseInt(page);
		}
		
	
		String opt=request.getParameter("opt");
		String condition=request.getParameter("condition");
		String id = (String)session.getAttribute("id");
		HashMap<String,Object> listOpt=new HashMap<String, Object>();
		
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage*10-9);
		listOpt.put("id", id);
		WBoardDAO wboardDAO=WBoardDAO.getInstance();
		int listcount =wboardDAO.getListCount(listOpt);
		List<WBoardVO> boardlist = wboardDAO.getBoardList(listOpt);
		
		int maxpage=(int)(listcount/10.0+0.9);
		int startpage=(int)(spage/5.0+0.8)*5-4;
		int endpage=startpage+4;
		if(endpage>maxpage)	endpage=maxpage;
		System.out.println("총 페이지수= " +maxpage);
		
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxpage", maxpage);
		
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("opt", opt);
		request.setAttribute("condition", condition);
		request.setAttribute("listcount", listcount);
		
		request.setAttribute("boardlist", boardlist);
		
		forward.setRedirect(false);
		forward.setPath("./board/WBoard/Wboard_list.jsp");
		
		return forward;
	}

}
