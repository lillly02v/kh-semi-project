package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.WRMemberDAO;
import net.user.member.db.WRMemberVO;

public class WRUpdateProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String secret = request.getParameter("userSecret");
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		int resid = Integer.parseInt(request.getParameter("userBirth"));
		String gender = request.getParameter("userGender");
		String job = request.getParameter("userJob");
		String phone = request.getParameter("userPhone");
		String email = request.getParameter("userEmail");
		String post = request.getParameter("userPost");
		String address = request.getParameter("userAddress");
		double addrlat = Double.parseDouble(request.getParameter("addressLat"));
		double addrlng = Double.parseDouble(request.getParameter("addressLng"));
		String intro = request.getParameter("userIntro");
		String keyword = request.getParameter("userKeyword");
		String pain = "";
		if(keyword.contains("장애")) {
			pain = "장애";
		} else {
			pain = "불편";
		}
		
		WRMemberVO member = new WRMemberVO();
		member.setSecret(secret);
		member.setId(id);
		member.setPass(pass);
		member.setResid(resid);
		member.setGender(gender);
		member.setJob(job);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPost(post);
		member.setAddress(address);
		member.setAddrlat(addrlat);
		member.setAddrlng(addrlng);
		member.setIntro(intro);
		member.setKey(keyword);
		member.setPain(pain);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		WRMemberDAO memberDAO = new WRMemberDAO();
		int result = memberDAO.update(member);
		out.println("<script>");
		if(result != 0) {
			out.println("alert('" + id + "님의 프로필이 수정 되었습니다.')");
			out.println("location.href='./wrMyProfile.net'");
		} else {
			out.println("alert('수정되지 않았습니다. 다시 입력해주세요');");
			out.println("history.back();");
		}
		out.println("</script>");
		return null;
	}

}
