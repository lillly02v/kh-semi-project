package net.user.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.member.db.VTMemberDAO;
import net.user.member.db.VTMemberVO;

public class VTUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("id");
		VTMemberDAO memberDAO = new VTMemberDAO();
		VTMemberVO member = memberDAO.member_info(id);
		
		forward.setPath("./user/member/update.jsp");
		forward.setRedirect(false);
		request.setAttribute("member", member);
		
		return forward;
	}

}
