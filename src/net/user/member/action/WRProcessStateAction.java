package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.WRMatchDAO;

public class WRProcessStateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String responseMb = request.getParameter("responseMB");
		
		System.out.println(boardNum);
		System.out.println(responseMb);
		
		WRMatchDAO matchDAO = new WRMatchDAO();
		int result = matchDAO.processState(boardNum, responseMb);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.print(result);
		return null;
	}

}
