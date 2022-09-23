package net.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.notice.db.NTBoardDAO;
import net.board.notice.db.NTBoardVO;

public class NTBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NTBoardDAO ndao=new NTBoardDAO();
		NTBoardVO boardDetail = new NTBoardVO();
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		ndao.setReadCountUpdate(num);
		
		boardDetail = ndao.getDetail(num);
		
		if(boardDetail == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		request.setAttribute("boardDetail", boardDetail);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./board/notice/nt_board_view.jsp");
		
		return forward;
	}

	
}
