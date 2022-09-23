package net.user.member.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.user.member.db.VTMemberDAO;
import net.user.member.db.VTMemberVO;
import net.user.member.db.WRMemberDAO;
import net.user.member.db.WRMemberVO;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		VTMemberDAO vtMemberDAO = new VTMemberDAO();
		WRMemberDAO wrMemberDAO = new WRMemberDAO();
		
		List<VTMemberVO> vtList = vtMemberDAO.getList();
		List<WRMemberVO> wrList = wrMemberDAO.getList();
		Map<String, Object> monthVtCounts = vtMemberDAO.monthListCount();
		Map<String, Object> monthWrCounts = wrMemberDAO.monthListCount();
		Map<String, Object> ageVtCounts = vtMemberDAO.ageListCount();
		Map<String, Object> ageWrCounts = wrMemberDAO.ageListCount();
		
		String[] month = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String[] age = {"10", "20", "30", "40", "50"};
		int[] monthVtCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] monthWrCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] ageVtPer = {0, 0, 0, 0, 0};
		int[] ageWrPer = {0, 0, 0, 0, 0};
		int[] ageTotalPer = {0, 0, 0, 0, 0};
		int vtSum = 0, wrSum = 0, totalSum = 0;
		for(String vtkeyName : monthVtCounts.keySet()) {
			for(int i = 0; i < month.length; i++) {
				if(vtkeyName.equals(month[i])) {
					monthVtCount[i] = (int) monthVtCounts.get(vtkeyName);
				}
			}
		}
		for(String wrkeyName : monthWrCounts.keySet()) {
			for(int i = 0; i < month.length; i++) {
				if(wrkeyName.equals(month[i])) {
					monthWrCount[i] = (int) monthWrCounts.get(wrkeyName);
				}
			}
		}
		for(String vtageName : ageVtCounts.keySet()) {
			for(int i = 0; i < age.length; i++) {
				if(vtageName.equals(age[i])) {
					ageVtPer[i] = (int) ageVtCounts.get(vtageName);
					vtSum = vtSum + ageVtPer[i];
				}
			}
		}
		for(String wrageName : ageWrCounts.keySet()) {
			for(int i = 0; i < age.length; i++) {
				if(wrageName.equals(age[i])) {
					ageWrPer[i] = (int) ageWrCounts.get(wrageName);
					wrSum = wrSum + ageWrPer[i];
				}
			}
		}
		
		totalSum = vtSum + wrSum;
		for(int i = 0; i < ageVtPer.length; i++) {
			ageTotalPer[i] = (ageVtPer[i] + ageWrPer[i]) * 100 / totalSum;
			ageVtPer[i] = ageVtPer[i] * 100 / vtSum;
			ageWrPer[i] = ageWrPer[i] * 100 / wrSum;
		}

		forward.setPath("./user/member/admin.jsp");
		forward.setRedirect(false);
		request.setAttribute("vtList", vtList);
		request.setAttribute("wrList", wrList);
		request.setAttribute("monthVtCount", monthVtCount);
		request.setAttribute("monthWrCount", monthWrCount);
		request.setAttribute("ageVtPer", ageVtPer);
		request.setAttribute("ageWrPer", ageWrPer);
		request.setAttribute("ageTotalPer", ageTotalPer);
		return forward;
	}

}
