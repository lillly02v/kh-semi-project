package net.board.news.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		NewsBoardDAO dao = new NewsBoardDAO();
		List<NewsBoardVO> boardlist = new ArrayList<NewsBoardVO>();
		int page = 1;
		int limit = 10;
		String search = "";
		String searchOpt = "";
		String load = request.getParameter("load");
		String opt = request.getParameter("opt"); // 선택옵션
		System.out.println("action opt=" + opt);

		String condition = request.getParameter("condition");
		System.out.println("action condition=" + condition);

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = " + page);

		if (condition != null) {
			search = request.getParameter("search");
		}

		if (opt != null) {
			searchOpt = request.getParameter("searchOpt");
		}

		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", page * 10 - 9);

		// 총 리스트 수
		int listcount = dao.getListCount(listOpt);
		// 리스트 받기
		boardlist = dao.getBoardList(listOpt, page, limit, search, searchOpt);

		int maxpage = (listcount + limit - 1) / limit;
		System.out.println("총 페이지수 = " + maxpage);

		int startpage = ((page - 1) / 10) * 10 + 1;
		System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + startpage);

		int endpage = startpage * 10 - 1;
		System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 = " + endpage);

		if (endpage > maxpage) {
			endpage = maxpage;
		}
			request.setAttribute("page", page); // 현재 페이지 수
			request.setAttribute("maxpage", maxpage); // 최대 페이지 수

			// 현재 페이지에 표시할 첫 페이지 수
			request.setAttribute("startpage", startpage);

			// 현재 페이지에 표시할 끝 페이지 수
			request.setAttribute("endpage", endpage);

			request.setAttribute("listcount", listcount);
			request.setAttribute("boardlist", boardlist);

			// request.setAttribute("aname", boardlist.get(0).getAname());

			request.setAttribute("opt", opt);
			request.setAttribute("condition", condition);

			session.setAttribute("load", load);
			session.setAttribute("fload", "list");

			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			// 글 목록 페이지로 이동하기 위해 경로를 설정합니다.
			forward.setPath("./board/news_board/news_board_list.jsp");
			return forward;
	}
}
