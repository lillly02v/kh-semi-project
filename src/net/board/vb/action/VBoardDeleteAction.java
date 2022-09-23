package net.board.vb.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.vb.db.VBoardDAO;

public class VBoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		boolean result =false;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		VBoardDAO vboardDAO=new VBoardDAO();
		System.out.println(num);
		boolean usercheck=vboardDAO.isBoardWriter(num, request.getParameter("vpass"));
		System.out.println(request.getParameter("vpass"));
		System.out.println(usercheck);
		System.out.println(num);
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
		result = vboardDAO.boardDelete(num);

		if(result==false) {
			System.out.println("삭제 실패");
			return null;
		}
		System.out.println("삭제 성공");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('삭제 되었습니다.');");
		out.println("location.href='./vboardList.vb';");
		out.println("</script>");
		out.close();
		
		return null;
	}

}
