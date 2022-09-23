package net.board.wb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.board.wb.db.WBReplyDAO;
import net.board.wb.db.WBReplyVO;

public class WBReplyAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		ActionForward forward = new ActionForward();
		WBReplyDAO replyDAO = new WBReplyDAO();
		WBReplyVO boardData = new WBReplyVO();
		int result = 0;
		int num = 0;

		
		
		
		boardData.setWwbnum(Integer.parseInt(request.getParameter("num")));
		boardData.setWrcont(request.getParameter("wrcont"));
		boardData.setWrsecret(request.getParameter("hidden"));
		
		// 답변을 DB에 저장하기 위해 boardData 객체를 파라미터로
		// DAO의 메서드 boardReply를 호출합니다.
		result = replyDAO.boardReply(boardData);

		// 답변 저장에 실패한 경우
		if (result == 0) {
			System.out.println("답장 실패");
			return null;
		}

		num = replyDAO.getListCount();
		// 답변 저장이 제대로 된 경우
		System.out.println("답장 완료");
		forward.setRedirect(true);
		// 답변 글 내용을 확인하기 위해 글 내용 보기 페이지를 경로로 설정합니다.
		forward.setPath("./wboardDetailAction.wb?wbnum=" + num);
		return forward;

	}

}
