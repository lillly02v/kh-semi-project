package net.user.member.action;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.user.member.db.VTMemberDAO;
import net.user.member.db.WRMemberDAO;
import net.user.member.db.WRMemberVO;

public class WRJoinProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPw");
		String name = request.getParameter("userName");
		int resid = Integer.parseInt(request.getParameter("userBirth"));
		String gender = (String)session.getAttribute("gender");
		String job = (String)session.getAttribute("job");
		String phone = request.getParameter("userPhone");
		String email = request.getParameter("userEmail");
		String post = request.getParameter("userPost");
		String address = request.getParameter("userAddress");
		double addrLat = Double.parseDouble(request.getParameter("addressLat"));
		double addrLng = Double.parseDouble(request.getParameter("addressLng"));
		String pain = (String)session.getAttribute("pain");
		String keyword = (String)session.getAttribute("keyword");
		String intro = request.getParameter("userIntro");
		String secret = request.getParameter("userSecret");
		
		WRMemberVO member = new WRMemberVO();
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setResid(resid);
		member.setGender(gender);
		member.setJob(job);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPost(post);
		member.setAddress(address);
		member.setAddrlat(addrLat);
		member.setAddrlng(addrLng);
		member.setPain(pain);
		member.setKey(keyword);
		member.setIntro(intro);
		member.setSecret(secret);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		WRMemberDAO memberDAO = new WRMemberDAO();
		int result = memberDAO.insert(member);
		out.println("<script>");
		if(result == 1) {
			out.println("alert('" + id + "님이 가입되셨습니다.');");
			out.println("location.href='login.net'");
		} else if(result == -1) {
			out.println("alert('아이디가 중복되었습니다.');");
			out.println("history.back();");
		}
		out.println("</script>");
		return null;
	}

}
