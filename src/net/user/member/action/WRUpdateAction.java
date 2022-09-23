package net.user.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.member.db.WRMemberDAO;
import net.user.member.db.WRMemberVO;


public class WRUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("id");
		WRMemberDAO memberDAO = new WRMemberDAO();
		WRMemberVO member = memberDAO.member_info(id);
		
		forward.setPath("./user/member/update.jsp");
		forward.setRedirect(false);
		request.setAttribute("member", member);
		
		return forward;
	}

}
