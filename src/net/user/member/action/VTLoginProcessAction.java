package net.user.member.action;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.user.member.db.VTMemberDAO;
import net.user.member.db.VTMemberVO;
import net.user.member.db.WRMemberDAO;

public class VTLoginProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String user = request.getParameter("user");
		String idStore = request.getParameter("idStore");
		
		WRMemberDAO wrMemberDAO = new WRMemberDAO();
		JSONObject res = new JSONObject();
		JSONArray array = wrMemberDAO.getAddressList();
		res.put("positions", array);
		System.out.println(res);
		
		try (FileWriter file = new FileWriter("D:\\workspace\\Dabong\\Dabong\\WebContent\\json\\welfareMap.json")) {
			//FileWriter file = new FileWriter("/Users/shane/git/semi_dabong/Dabong/WebContent/json/welfareMap.json"))
            file.write(res.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		VTMemberDAO memberDAO = new VTMemberDAO();
		VTMemberVO memberVO = memberDAO.member_info(id);
		String name = memberVO.getName();
		System.out.println(name);
		int result = memberDAO.isId(id, pass);
		double[] loc = memberDAO.addressLatLng(id);
		
		System.out.println("결과는 " + result);
		if(result == 1) {
			HttpSession session = request.getSession();
			Cookie cookie = new Cookie("rememberId", request.getParameter("id"));
			if(idStore != null && idStore.equals("idStore")) {
				cookie.setMaxAge(10 * 60);
				response.addCookie(cookie);
			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			session.setAttribute("id", id);
			session.setAttribute("user", user);
			session.setAttribute("name", name);
			session.setAttribute("addressLat", loc[0]);
			session.setAttribute("addressLng", loc[1]);
		
			forward.setRedirect(true);
			forward.setPath("./boardMap.net");
			return forward;
		} else {
			String message = "";
			if(result == -1) {
				message = "아이디가 존재하지 않습니다.";
			} else {
				message = "비밀번호가 일치하지 않습니다.";
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("location.href='./login.net';");
			out.println("</script>");
			out.close();
			return null;
		}
	}

}
