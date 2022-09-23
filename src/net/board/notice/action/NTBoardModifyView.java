package net.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.notice.db.NTBoardDAO;
import net.board.notice.db.NTBoardVO;

public class NTBoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		NTBoardDAO ndao=new NTBoardDAO();
		NTBoardVO boardData = new NTBoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		boardData=ndao.getDetail(num);
		
		if(boardData == null) {
			System.out.println("수정 페이지 이동 실패");
			return null;
		}
		
		System.out.println("수정 페이지 이동 성공");
		
		request.setAttribute("boardData", boardData);
		
		forward.setRedirect(false);
		forward.setPath("./board/notice/nt_board_modify.jsp");
		return forward;
	}

}
