package net.user.member.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.board.vb.db.VBoardDAO;
import net.board.vb.db.VBoardVO;

public class VTProfileListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		VBoardDAO boardDAO = new VBoardDAO();
		List<VBoardVO> list = new ArrayList<VBoardVO>();
		list = boardDAO.profileList(userId);
		
		JSONArray arr = new JSONArray();
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("pfile", list.get(i).getVbsub());
			obj.put("boardNum", list.get(i).getVbnum());
			
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
