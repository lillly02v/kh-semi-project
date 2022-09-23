package net.board.wb.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.wb.db.WBReplyDAO;
import net.board.wb.db.WBReplyVO;

public class WBReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WBReplyDAO wbreplydao= new WBReplyDAO();
		WBReplyVO RboardDetail= new WBReplyVO();
		List<WBReplyVO> boardlist=new ArrayList<WBReplyVO>();
		request.setCharacterEncoding("UTF-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		RboardDetail=wbreplydao.getDetail(num);
		
		if(RboardDetail==null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		request.setAttribute("RboardDetail", RboardDetail);
		ActionForward forward=new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./board/WBoard/WBoard_reply.jsp");
		return forward;
	}

}
