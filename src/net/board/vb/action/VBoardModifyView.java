package net.board.vb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBoardDAO;
import net.board.vb.db.VBoardVO;

public class VBoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		VBoardDAO vboardDAO = new VBoardDAO();
		VBoardVO vboardData = new VBoardVO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		vboardData=vboardDAO.getDetail(num);
		if(vboardData==null) {
			System.out.println("수정 페이지 이동 실패");
			return null;
		}
		System.out.println("수정 페이지 이동 성공");
		
		request.setAttribute("vboardData", vboardData);
		
		forward.setRedirect(false);
		forward.setPath("./board/VBoard/VBoard_modify.jsp");
		return forward;
	}

}
