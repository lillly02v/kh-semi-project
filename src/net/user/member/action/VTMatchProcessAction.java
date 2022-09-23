package net.user.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.VTMatchDAO;
import net.user.member.db.VTMatchVO;

public class VTMatchProcessAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String state = request.getParameter("state");
		int mNum = Integer.parseInt(request.getParameter("mNum"));
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String requestMb = request.getParameter("requestMB");
		String responseMb = request.getParameter("responseMB");
		
		
		System.out.println(state);
		System.out.println(mNum);
		System.out.println(boardNum);
		System.out.println(requestMb);
		System.out.println(responseMb);
		
		VTMatchDAO matchDAO = new VTMatchDAO();
		VTMatchVO matchVO = new VTMatchVO();
		matchVO.setmNum(mNum);
		matchVO.setBoardNum(boardNum);
		matchVO.setRequestMb(requestMb);
		matchVO.setResponseMb(responseMb);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		int result = 0;
		if(state.equals("approve")) {
			result = matchDAO.approveCancleMatch(matchVO, state);
			resultState(result, out, state);
		} else if(state.equals("reject")){
			result = matchDAO.rejectMatch(matchVO);
			resultState(result, out, state);
		} else if(state.equals("cancle")) {
			result = matchDAO.approveCancleMatch(matchVO, state);
			resultState(result, out, state);
		} else if(state.equals("success")) {
			out.println("<script>");
			out.println("alert('매칭이 완료된 상태입니다.');");
			out.println("</script>");
			out.close();
		} else if(state.equals("confirm")) {
			result = matchDAO.approveCancleMatch(matchVO, state);
			resultState(result, out, state);
		}
		return null;
	}
	
	public void resultState(int result, PrintWriter out, String state) {
		if(result != 0) {
			out.print(state);
		} else {
			out.println("<script>");
			out.println("alert('실행 되지 않았습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}
		out.close();
	}

}
