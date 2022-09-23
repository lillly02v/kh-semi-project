package net.board.wb.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class VBFrontController
 */
@WebServlet("*.wb")
public class WBoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WBoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		String RequestURI = request.getRequestURI();
		System.out.println("RequestURI= " + RequestURI);

		String contextPath = request.getContextPath();
		System.out.println("contextPath= " + contextPath);

		String command = RequestURI.substring(contextPath.length());
		System.out.println("command1= " + command);

		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/wboardList.wb")) {
			action = new WBoardListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardWrite.wb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		//포워딩 방식으로 주소가 바뀌지 않아
			forward.setPath("./board/WBoard/WBoard_write.jsp");
		} else if(command.contentEquals("/wboardAddAction.wb")) {
			action = new WBoardAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}  else if(command.equals("/wboardDelete.wb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		//포워딩 방식으로 주소가 바뀌지 않아요
			forward.setPath("./board/WBoard/WBoard_delete.jsp");
		
		}else if(command.equals("/wboardDeleteAction.wb")) {
			action= new WBoardDeleteAction();
			try {
			forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		 
		} else if(command.equals("/wboardSearchAction.wb")) {
			action= new WBoardSearchAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wbReplyListAction.wb")) {
			action= new WBReplyListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wbReplyAddAction.wb")) {
			action= new WBReplyAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wbReplyDeleteAction.wb")) {
			action= new WBReplyDeleteAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wbReplyUpdateAction.wb")) {
			action= new WBReplyUpdateAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardDetailAction.wb")) {
			action= new WBoardDetailAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardModifyAction.wb")) {
			action= new WBoardModifyAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardModifyView.wb")) {
			action= new WBoardModifyView();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardFileDownAction.wb")) {
			action= new WBoardFileDownAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wboardListAction2.wb")) {
			action=new WBoardListAction2();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/wbReplyAddAction.wb")) {
			action=new WBReplyAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/products5.wb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		//포워딩 방식으로 주소가 바뀌지 않아
			forward.setPath("./board/WBoard/products5.jsp");
		}
	
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
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
