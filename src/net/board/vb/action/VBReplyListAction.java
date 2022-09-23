package net.board.vb.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBReplyDAO;
import net.board.vb.db.VBReplyVO;

public class VBReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		VBReplyDAO vbreplydao= new VBReplyDAO();
		VBReplyVO RboardDetail= new VBReplyVO();
		List<VBReplyVO> boardlist=new ArrayList<VBReplyVO>();
		request.setCharacterEncoding("UTF-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		RboardDetail=vbreplydao.getDetail(num);
		
		if(RboardDetail==null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		request.setAttribute("RboardDetail", RboardDetail);
		ActionForward forward=new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./board/VBoard/VBoard_reply.jsp");
		return forward;
	}

}
