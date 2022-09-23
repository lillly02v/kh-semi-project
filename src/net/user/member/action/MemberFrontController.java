package net.user.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ADBoardController
 */
@WebServlet("*.net")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String RequestURI = request.getRequestURI();
    	System.out.println("RequestURI = " + RequestURI);
    	
    	String contextPath = request.getContextPath();
    	System.out.println("contextPath = " + contextPath);
    	
    	String command = RequestURI.substring(contextPath.length());
    	System.out.println("command = " + command);
    	
    	/*
    	String servletPath = request.getServletPath();
    	System.out.println("servletPath = " + servletPath);
    	*/
    	Action action = null;
    	ActionForward forward = null;
    	if(command.equals("/login.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/login.jsp");
    	} else if(command.equals("/logout.net")) {
    		action = new LogoutAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/userInfo.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/userInfo.jsp");
    	} else if(command.equals("/join.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join1.jsp");
    	} else if(command.equals("/join2.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join2.jsp");
    	} else if(command.equals("/join3.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join3.jsp");
    	} else if(command.equals("/join4.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join4.jsp");
    	} else if(command.equals("/join5.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join5.jsp");
    	} else if(command.equals("/join6.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join6.jsp");
    	} else if(command.equals("/join7.net")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/join7.jsp");
    	} else if(command.equals("/vtJoinProcess.net")) {
    		action = new VTJoinProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}  else if(command.equals("/wrJoinProcess.net")) {
    		action = new WRJoinProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtIdCheck.net")) {
    		action = new VTIdCheckAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrIdCheck.net")) {
    		action = new WRIdCheckAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtLoginProcess.net")) {
    		action = new VTLoginProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrLoginProcess.net")) {
    		action = new WRLoginProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/boardMap.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/searchMap.jsp");
    	} else if(command.equals("/vtUpdateView.net")) {
    		action = new VTUpdateAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrUpdateView.net")) {
    		action = new WRUpdateAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtUpdateProcess.net")){
    		action = new VTUpdateProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrUpdateProcess.net")){
    		action = new WRUpdateProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/delete.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/delete.jsp");
    	} else if(command.equals("/vtDeleteProcess.net")) {
    		action = new VTDeleteProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrDeleteProcess.net")) {
    		action = new WRDeleteProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/admin.net")) {
    		action = new MemberListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/finder.net")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("./user/member/finder.jsp");
    	} else if(command.equals("/vtPassFinder.net")) {
    		action = new VTPassFindProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrPassFinder.net")) {
    		action = new WRPassFindProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtSendMatch.net")) {
    		action = new VTSendMatchAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrSendMatch.net")) {
    		action = new WRSendMatchAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtMessageView.net")) {
    		action = new VTMessageListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrMessageView.net")) {
    		action = new WRMessageListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtMatchProcess.net")) {
    		action = new VTMatchProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrMatchProcess.net")) {
    		action = new WRMatchProcessAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtProcessState.net")) {
    		action = new VTProcessStateAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrProcessState.net")) {
    		action = new WRProcessStateAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtMyProfile.net")) {
    		action = new VTMyProfileAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrMyProfile.net")) {
    		action = new WRMyProfileAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtProfileProcess.net")) {
    		action = new VTProfileListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrProfileProcess.net")) {
    		action = new WRProfileListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/vtAlarmView.net")) {
    		action = new VTAlarmListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else if(command.equals("/wrAlarmView.net")) {
    		action = new WRAlarmListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
