package net.board.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		boolean result = false;
		//전달받은 파라미터 num 변수에 저장합니다.
		int num = Integer.parseInt(request.getParameter("num"));
		// 전달받은 파라미터 num 변수에 저장합니다.
		NewsBoardDAO dao = new NewsBoardDAO();
		NewsBoardVO boardData = new NewsBoardVO();

		boardData.setNenum(num);
		boardData.setNesub(request.getParameter("nesub"));
		boardData.setNecont(request.getParameter("necont"));
		
		boardData.setNefiles(request.getParameter("nefiles"));

		result = dao.boardModify(boardData);
		if (!result) {
			System.out.println("수정 실패");
			return null;
		}
		System.out.println("수정 성공");

		request.setAttribute("boardData", boardData);

		forward.setRedirect(false);
		forward.setPath("NewsBoardDetailAction.news?num=" + boardData.getNenum());

		return forward;
	}
}
