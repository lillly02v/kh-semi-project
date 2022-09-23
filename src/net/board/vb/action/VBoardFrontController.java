package net.board.vb.action;

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
@WebServlet("*.vb")
public class VBoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VBoardFrontController() {
        super();

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
		
		if(command.equals("/vboardList.vb")) {
			action = new VBoardListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardWrite.vb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		
			forward.setPath("./board/VBoard/VBoard_write.jsp");
		} else if(command.contentEquals("/vboardAddAction.vb")) {
			action = new VBoardAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}  else if(command.equals("/vboardDelete.vb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		
			forward.setPath("./board/VBoard/VBoard_delete.jsp");
		
		}else if(command.equals("/vboardDeleteAction.vb")) {
			action= new VBoardDeleteAction();
			try {
			forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		 
		} else if(command.equals("/vboardSearchAction.vb")) {
			action= new VBoardSearchAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vbReplyListAction.vb")) {
			action= new VBReplyListAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vbReplyAddAction.vb")) {
			action= new VBReplyAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vbReplyDeleteAction.vb")) {
			action= new VBReplyDeleteAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vbReplyUpdateAction.vb")) {
			action= new VBReplyUpdateAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardDetailAction.vb")) {
			action= new VBoardDetailAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardModifyAction.vb")) {
			action= new VBoardModifyAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardModifyView.vb")) {
			action= new VBoardModifyView();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardFileDownAction.vb")) {
			action= new VBoardFileDownAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vboardListAction2.vb")) {
			action=new VBoardListAction2();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/vbReplyAddAction.vb")) {
			action=new VBReplyAddAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/products5.vb")) {
			forward = new ActionForward();
			forward.setRedirect(false);		
			forward.setPath("./board/VBoard/products5.jsp");
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
			doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request, response);
	}

}
