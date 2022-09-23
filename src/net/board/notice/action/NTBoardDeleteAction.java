package net.board.notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.notice.db.NTBoardDAO;

public class NTBoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		boolean result = false;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		NTBoardDAO ndao=new NTBoardDAO();
		
		result = ndao.boardDelete(num);
		
		
		if(result == false) {
			System.out.println("삭제 실패");
			return null;
		}
		
		System.out.println("삭제 성공");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제 되었습니다.');");
		out.println("location.href='./NTBoardList.nt';");
		out.println("</script>");
		out.close();
		return null;
	}

}
