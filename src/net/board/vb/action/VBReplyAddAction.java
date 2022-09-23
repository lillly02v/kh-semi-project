package net.board.vb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBReplyDAO;
import net.board.vb.db.VBReplyVO;

public class VBReplyAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		ActionForward forward = new ActionForward();
		VBReplyDAO replyDAO = new VBReplyDAO();
		VBReplyVO boardData = new VBReplyVO();
		int result = 0;
		int num = 0;

		
		boardData.setVvbnum(Integer.parseInt(request.getParameter("num")));
		boardData.setVrcont(request.getParameter("vrcont"));
		boardData.setVrsecret(request.getParameter("hidden"));
		
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
		forward.setPath("./vboardDetailAction.vb?vbnum=" + num);
		return forward;

	}

}
