package net.board.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NTBoardFrontController
 */
@WebServlet("*.nt")
public class NTBoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NTBoardFrontController() {
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
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/NTBoardList.nt")) {
			action = new NTBoardListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else if (command.equals("/NTBoardListAction.nt")) {
			action = new NTBoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/NTBoardWrite.nt")) {
			forward = new ActionForward();
			forward.setRedirect(false);	
			forward.setPath("./board/notice/nt_board_write.jsp");
			
		} else if(command.equals("/NTBoardAddAction.nt")) {
			action = new NTBoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/NTBoardDetailAction.nt")) {
			action = new NTBoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/NTBoardModifyView.nt")) {
			action = new NTBoardModifyView();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/NTBoardModifyAction.nt")) {
			action = new NTBoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/NTBoardDelete.nt")) {
			forward = new ActionForward();
			forward.setRedirect(false);		//포워딩 방식으로 주소가 바뀌지 않아요

			forward.setPath("./board/notice/nt_board_delete.jsp");
			
		} else if(command.equals("/NTBoardDeleteAction.nt")) {
			action = new NTBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} else if(command.equals("/NTBoardFileDown.nt")) {
			action = new NTBoardFileAction();
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
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
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
