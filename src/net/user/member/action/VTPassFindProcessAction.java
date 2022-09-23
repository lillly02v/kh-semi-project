package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.VTMemberDAO;

public class VTPassFindProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("userID");
		String email = request.getParameter("userEmail");
		String phone = request.getParameter("userPhone");
		
		VTMemberDAO memberDAO = new VTMemberDAO();
		String pass = memberDAO.userPassFind(id, email, phone);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if(pass.equals("") || pass == null) {
			out.println("alert('잘못 입력하셨습니다.');");
			out.println("history.go(-1);");
		} else {
			out.println("alert('" + id + "님의 비밀번호는 " + pass + "');");
			out.println("location.href='./login.net';");
		}
		out.println("</script>");
		return null;
	}

}
