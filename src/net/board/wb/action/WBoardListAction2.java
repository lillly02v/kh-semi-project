package net.board.wb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WBoardListAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		WBoardDAO wboardDAO=new WBoardDAO();
		List<WBoardVO> boardlist = new ArrayList<WBoardVO>();
		
		int page =1;
		int limit =10;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지= "+page);
		HashMap<String,Object> listOpt=new HashMap<String, Object>();
		int listcount =wboardDAO.getListCount(listOpt);
		
		//boardlist=wboardDAO.getBoardList(page, limit);
		
		int maxpage=(listcount+limit -1)/limit;
		System.out.println("총 페이지수= " +maxpage);
		
		int startpage=((page-1)/10)*10+1;
		System.out.println("현재 페이지에 보여줄 시작 페이지수=" +startpage);
		
		int endpage=startpage*10-1;
		System.out.println("현재 페이지에서 보여줄 마지막 페이지 수=" +endpage);
		
		if(endpage>maxpage) {
			endpage=maxpage;
		}
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
	
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/WBoard/Wboard_view.jsp");
		
		return forward;
	}

}
