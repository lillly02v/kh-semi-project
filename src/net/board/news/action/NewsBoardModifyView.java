package net.board.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		NewsBoardDAO dao = new NewsBoardDAO();
		NewsBoardVO boardData = new NewsBoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		boardData = dao.getDetail(num);
		
		if(boardData == null) {
			System.out.println("수정 페이지 이동 실패");
			return null;
		}
		
		System.out.println("수정 페이지 이동 성공");
		
		request.setAttribute("boardData", boardData);
		forward.setRedirect(false);
		forward.setPath("./board/news_board/news_board_modify.jsp");
		return forward;
	}

}
