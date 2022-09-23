package net.user.member.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WRProfileListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		WBoardDAO boardDAO = new WBoardDAO();
		List<WBoardVO> list = new ArrayList<WBoardVO>();
		list = boardDAO.profileList(userId);
		
		JSONArray arr = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("pfile", list.get(i).getWbsub());
			obj.put("boardNum", list.get(i).getWbnum());
			
			arr.add(obj);
		}
		System.out.println(arr);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream()));
		out.print(arr);
		out.flush();
		out.close();
		return null;
	}

}
