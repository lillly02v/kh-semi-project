package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.member.db.VTMemberDAO;

public class VTDeleteProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(id.equals("admin")) {
			out.println("<script>");
			out.println("alert('관리자는 삭제 할 수 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			VTMemberDAO memberDAO = new VTMemberDAO();
			int result = memberDAO.delete(id, pass);
			out.println("<script>");
			if(result != 0) {
				out.println("alert('" + id + "님의 계정이 삭제되었습니다.');");
				if(((String)session.getAttribute("id")).equals("admin")) {
					out.println("location.href='admin.net'");
				} else {
					out.println("location.href='login.net';");
				}
			} else {
				out.println("alert('삭제할 수 없습니다.');");
				out.println("history.back();");
			}
			out.println("</script>");
		}
		return null;
	}

}
