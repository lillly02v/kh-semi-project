package net.board.notice.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.notice.db.NTBoardDAO;
import net.board.notice.db.NTBoardVO;

public class NTBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		boolean result = false;
		
		NTBoardDAO ndao=new NTBoardDAO();
		NTBoardVO boardData = new NTBoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String ntfiles = request.getParameter("ntfiles1");
		if(ntfiles == null || ntfiles.equals("")) {
			ntfiles = request.getParameter("ntfiles");
		}
		boardData=ndao.getDetail(num);
		
		boardData.setNtnum(num);
		boardData.setNtsub(request.getParameter("ntsub"));
		boardData.setNtcont(request.getParameter("ntcont"));
		boardData.setNtfiles(ntfiles);
		
		result=ndao.boardModify(boardData);
		if(!result) {
			System.out.println("수정 실패");
			return null;
		}
		System.out.println("수정 성공");
		
		request.setAttribute("boardData", boardData);
		
		forward.setRedirect(true);
		forward.setPath("./NTBoardDetailAction.nt?num=" + boardData.getNtnum());
		
		return forward;
	}

}
