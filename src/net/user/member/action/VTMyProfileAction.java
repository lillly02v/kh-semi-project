package net.user.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.user.member.db.VTMemberDAO;
import net.user.member.db.VTMemberVO;

public class VTMyProfileAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		String type = request.getParameter("type");
		System.out.println(type);
		String id = "";
		if(type == null){
			id = (String)session.getAttribute("id");
			forward.setPath("./user/profile/my_profile.jsp");
		} else if(type.equals("other")) {
			id = request.getParameter("id");
			forward.setPath("./user/profile/other_profile.jsp");
		}
		System.out.println(id);
		VTMemberDAO memberDAO = new VTMemberDAO();
		VTMemberVO memberVO = memberDAO.member_info(id);
		int age = memberDAO.userAge(id);
		String secret = memberVO.getSecret();
		
		forward.setRedirect(false);
		request.setAttribute("member", memberVO);
		request.setAttribute("userAge", age);
		session.setAttribute("secret", secret);
		return forward;
	}

}
