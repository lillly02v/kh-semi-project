package net.board.news.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardAlbumAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		NewsBoardDAO dao = new NewsBoardDAO();
		List<NewsBoardVO> boardlist = new ArrayList<NewsBoardVO>();
		int page = 1;
		int limit = 99;
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
		listOpt.put("start", page * 12 - 11);
		
		// 총 리스트 수
		int listcount = dao.getListCount(listOpt);
		// 리스트 받기
		boardlist = dao.getBoardAlbum(listOpt, page, limit, search, searchOpt);
		
		int maxpage = (listcount + limit - 1) / limit;
		System.out.println("총 페이지수 = " + maxpage);
		
		int startpage = ((page - 1) / 10) * 10 + 1;
		System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + startpage);

		int endpage = startpage * 10 - 1;
		System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 = " + endpage);

		if (endpage > maxpage) {
			endpage = maxpage;
		}

		if(page == 1) {
			request.setAttribute("page", page); // 현재 페이지 수
			request.setAttribute("maxpage", maxpage); // 최대 페이지 수

			request.setAttribute("listcount", listcount);
			request.setAttribute("boardlist", boardlist);
			
			//request.setAttribute("aname", boardlist.get(0).getAname());

			request.setAttribute("opt", opt);
			request.setAttribute("condition", condition);
			
			session.setAttribute("load", load);
			session.setAttribute("fload", "album");
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			// 글 목록 페이지로 이동하기 위해 경로를 설정합니다.
			forward.setPath("./board/news_board/news_board_album.jsp");
			return forward;
		} else if(page > 1 && !boardlist.isEmpty()) {
			JSONArray arr = new JSONArray();
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			for(int i = 0; i < boardlist.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("files", boardlist.get(i).getNefiles());
				obj.put("sub", boardlist.get(i).getNesub());
				obj.put("visit", Integer.toString(boardlist.get(i).getNevisit()));
				obj.put("date", sdformat.format(boardlist.get(i).getNedate()));
				obj.put("name", boardlist.get(i).getAname());
				obj.put("nenum", Integer.toString(boardlist.get(i).getNenum()));
				arr.add(obj);
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream()));
			out.print(arr);
			out.flush();
			out.close();
		} 
		return null;
	}
}
