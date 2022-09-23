package net.board.wb.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WBoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		boolean result = false;
		
		int num= Integer.parseInt(request.getParameter("num"));
		System.out.println("wbnum");
		WBoardDAO wboardDAO=new WBoardDAO();
		WBoardVO wboardData=new WBoardVO();
		
		boolean usercheck= wboardDAO.isBoardWriter(num, request.getParameter("wpass"));
		
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
		wboardData.setWbnum(num);
		wboardData.setWid(request.getParameter("wid"));
		wboardData.setWbsub(request.getParameter("wbsub"));
		wboardData.setWbcont(request.getParameter("wbcont"));
		wboardData.setWbweek(request.getParameter("wbweek"));
		wboardData.setWbpostime(request.getParameter("wbpostime"));
		wboardData.setWbarea(request.getParameter("wbarea"));
		wboardData.setWbrelig(request.getParameter("wbrelig"));
		wboardData.setWbgenv(request.getParameter("wbgenv"));
		wboardData.setWbhope(request.getParameter("wbhope"));
		wboardData.setWbhopeve(request.getParameter("wbhopeve"));
		
		result=wboardDAO.boardModify(wboardData);
		if(!result) {
			System.out.println("수정 실패");
			return null;
		}
		System.out.println("수정 성공");
		
		request.setAttribute("wboardData", wboardData);
		forward.setRedirect(false);
		forward.setPath("/wboardDetailAction.wb?num="+wboardData.getWbnum());
		
		return forward;
	}

}
