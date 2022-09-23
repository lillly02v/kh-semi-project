package net.user.member.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.user.member.db.VTMatchDAO;
import net.user.member.db.VTMatchVO;
import net.user.member.db.VTMemberDAO;
import net.user.member.db.VTMemberVO;

public class WRAlarmListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String requestMB = (String)session.getAttribute("id");
		
		VTMatchDAO matchDAO = new VTMatchDAO();
		List<VTMatchVO> list = new ArrayList<VTMatchVO>();
		list = matchDAO.alarmGetList(requestMB);
		
		VTMemberDAO memberDAO = new VTMemberDAO();
		
		JSONArray arr = new JSONArray();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = new JSONObject();
			VTMemberVO member = memberDAO.member_info(list.get(i).getResponseMb());
			obj.put("mNum", Integer.toString(list.get(i).getmNum()));
			obj.put("boardNum", Integer.toString(list.get(i).getBoardNum()));
			obj.put("responseMb", list.get(i).getResponseMb());
			obj.put("responseName", member.getName());
			obj.put("responsePhone", member.getPhone());
			obj.put("responseEmail", member.getEmail());
			obj.put("approveDate", sdformat.format(list.get(i).getApproveDate()));
			System.out.println(obj);
			arr.add(obj);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream()));
		out.print(arr);
		out.flush();
		out.close();
		return null;
	}

}
