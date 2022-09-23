package net.board.vb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBoardDAO;
import net.board.vb.db.VBoardVO;

public class VBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		VBoardDAO vboardDAO= new VBoardDAO();
		VBoardVO boardDetail=new VBoardVO();
		
		request.setCharacterEncoding("UTF-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		vboardDAO.setReadCountUpdate(num);
		
		boardDetail=vboardDAO.getDetail(num);
		
		if(boardDetail==null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		request.setAttribute("boardDetail", boardDetail);
		ActionForward forward=new ActionForward();

		forward.setRedirect(false);
		forward.setPath("/board/VBoard/VBoard_view.jsp");
		
		return forward;
	}

}
