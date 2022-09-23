package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.VTMemberDAO;

public class VTIdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		VTMemberDAO memberDAO = new VTMemberDAO();
		
		String id = request.getParameter("userID");
		int result = memberDAO.idCheck(id);
		if(id.contains("admin")) {
			result = 2;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		return null;
	}
	
}
