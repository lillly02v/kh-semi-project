package net.board.wb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WBoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		WBoardDAO wboardDAO = new WBoardDAO();
		WBoardVO wboardData = new WBoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		wboardData=wboardDAO.getDetail(num);
		
		if(wboardData==null) {
			System.out.println("수정 페이지 이동 실패");
			return null;
		}
		System.out.println("수정 페이지 이동 성공");
		
		request.setAttribute("boardData", wboardData);
		
		forward.setRedirect(false);
		forward.setPath("./board/WBoard/WBoard_modify.jsp");
		return forward;
	}

}
