package net.board.vb.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBoardDAO;
import net.board.vb.db.VBoardVO;

public class VBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		boolean result = false;
		
		int num= Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		VBoardDAO vboardDAO=new VBoardDAO();
		VBoardVO vboardData=new VBoardVO();
		
		boolean usercheck= vboardDAO.isBoardWriter(num, request.getParameter("vpass"));
		
		if(usercheck==false) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
			
		}
		vboardData.setVbnum(num);
		vboardData.setVbsub(request.getParameter("vbsub"));
		vboardData.setVbcont(request.getParameter("vbcont"));
		vboardData.setVbweek(request.getParameter("vbweek"));
		vboardData.setVbpostime(request.getParameter("vbpostime"));
		vboardData.setVbchrac(request.getParameter("vbchrac"));
		vboardData.setVbarea(request.getParameter("vbarea"));
		vboardData.setVbrelig(request.getParameter("vbrelig"));
		vboardData.setVbexper(request.getParameter("vbexper"));
		vboardData.setVbexcont(request.getParameter("vbexcont"));
		
		result=vboardDAO.boardModify(vboardData);
		if(!result) {
			System.out.println("수정 실패");
			return null;
		}
		System.out.println("수정 성공");
		
		request.setAttribute("vboardData", vboardData);
		forward.setRedirect(false);
		forward.setPath("/vboardDetailAction.vb?num="+vboardData.getVbnum());
		
		return forward;
	}

}
