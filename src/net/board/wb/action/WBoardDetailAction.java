package net.board.wb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		WBoardDAO wboardDAO= new WBoardDAO();
		WBoardVO boardDetail=new WBoardVO();
		
		request.setCharacterEncoding("UTF-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		wboardDAO.setReadCountUpdate(num);
		
		boardDetail=wboardDAO.getDetail(num);
		
		if(boardDetail==null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		request.setAttribute("boardDetail", boardDetail);
		ActionForward forward=new ActionForward();

		forward.setRedirect(false);
		forward.setPath("./board/WBoard/WBoard_view.jsp");
		
		return forward;
	}

}
