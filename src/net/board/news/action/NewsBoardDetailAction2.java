package net.board.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardDetailAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NewsBoardDAO dao = new NewsBoardDAO();
		NewsBoardVO detail = new NewsBoardVO();
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		dao.setReadCountUpdate(num);
		
		detail = dao.getDetail(num);
		if(detail == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		
		request.setAttribute("detail", detail);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./board/news_board/news_board_view.jsp");
		
		return forward;
	}

}
