package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.WRMatchDAO;
import net.user.member.db.WRMatchVO;

public class WRSendMatchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String requestMB = request.getParameter("requestMB");
		String responseMB = request.getParameter("responseMB");
		String choice = request.getParameter("choiceVal");
		String matching = "매칭중";
		
		WRMatchDAO matchDAO = new WRMatchDAO();
		WRMatchVO matchVO = new WRMatchVO();
		matchVO.setBoardNum(boardNum);
		matchVO.setRequestMb(requestMB);
		matchVO.setResponseMb(responseMB);
		matchVO.setMatching(matching);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(choice == null) {
			String text = matchDAO.stateBtn(matchVO);
			out.print(text);
		} else if(choice.equals("choice")){
			int result = matchDAO.sendMatch(matchVO);
			
			out.println("<script>");
			if(result != 0) {
				out.println("alert('" + responseMB + "님에게 매칭 메세지를 보냈습니다.');");
				out.println("history.go(-1);");
				
			} else {
				out.println("alert('매칭 할 수가 없습니다.');");
				out.println("history.go(-1);");
			}
			out.println("</script>");
		}
		return null;
	}

}
