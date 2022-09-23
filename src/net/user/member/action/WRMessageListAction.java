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

import net.user.member.db.WRMatchDAO;
import net.user.member.db.WRMatchVO;

public class WRMessageListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String responseMB = (String)session.getAttribute("id");
		
		WRMatchDAO matchDAO = new WRMatchDAO();
		List<WRMatchVO> list = new ArrayList<WRMatchVO>();
		list = matchDAO.messageGetList(responseMB);
		
		JSONArray arr = new JSONArray();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("mNum", Integer.toString(list.get(i).getmNum()));
			obj.put("boardNum", Integer.toString(list.get(i).getBoardNum()));
			obj.put("requestMb", list.get(i).getRequestMb());
			obj.put("matching", list.get(i).getMatching());
			obj.put("matchDate", sdformat.format(list.get(i).getMatchDate()));
//				obj.put("approveDate", sdformat.format(list.get(i).getApproveDate()));
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
