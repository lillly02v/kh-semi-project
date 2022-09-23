package net.board.notice.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.notice.db.NTBoardDAO;
import net.board.notice.db.NTBoardVO;

public class NTBoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NTBoardDAO ndao=new NTBoardDAO();
		List<NTBoardVO> boardlist = new ArrayList<NTBoardVO>();
		
		int page =1;
		int limit = 10;
		String search="";
		String searchOpt="";
		
		String opt = request.getParameter("opt"); //선택옵션

		System.out.println("action opt=" + opt);
		
		String condition = request.getParameter("condition");
		System.out.println("action condition=" + condition);
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("넘어온 페이지 = "+page);
		
		if (condition != null) {
	         search = request.getParameter("search");
	      }
		  System.out.println("search = " + search);

	      if (opt != null) {
	         searchOpt =  request.getParameter("searchOpt");
	      }
	      System.out.println("searchOpt = " + searchOpt);

	      HashMap<String, Object> listOpt = new HashMap<String, Object>();
	      listOpt.put("opt", opt);
	      listOpt.put("condition", condition);
	      listOpt.put("start", page * 10 - 9);
		
	
		
	      /*
	       * search (검색옵션)이 비어있지  않다면, Ajax 처리 (true를 설정했음)

	       * 
	       */
		if(search != null && !search.equals("")) {
			
			boardlist = ndao.getBoardList(listOpt, page, limit, search, searchOpt);
			
			//페이지의 리스트는 검색한 개수만큼 설정
			int listcount = boardlist.size(); 

			int maxpage =(listcount+limit-1)/limit;
			System.out.println("총 페이지수 = " + maxpage);
			
			int startpage = ((page - 1) / 10) * 10 + 1;
			System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + startpage);
			
			int endpage = startpage * 10 -1;
			System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 = " + endpage);
			
			if(endpage > maxpage) {
				endpage = maxpage;
			}
			
			listcount = boardlist.size();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();

			//페이지 설정	
			int num = listcount - ((page - 1) * 10);
		
			
			for (NTBoardVO ntBoardVO : boardlist) {
				writer.println("<tr>");
				writer.println("<td>");
				writer.println(num);
				writer.println("</td>");
				writer.println("<td>");
				writer.println("<div>");
				writer.println("<a href='./NTBoardDetailAction.nt?num="+ntBoardVO.getNtnum()+"'>"+ntBoardVO.getNtsub()+"</a>");
				writer.println("</div>");
				writer.println("</td>");
				writer.println("<td>");
				writer.println("<div>" + ntBoardVO.getAname() + "</div>");
				writer.println("</td>");
				writer.println("<td>");
				writer.println("<div>" + ntBoardVO.getNtdate() + "</div>");
				writer.println("</td>");
				writer.println("<td>");
				writer.println("<div>" + ntBoardVO.getNtvisit() + "</div>");
				writer.println("</td>");
				writer.println("</tr>");

				num -= 1;
			}

			if (listcount == 0) {
				writer.println("<tr>");
				writer.println("<td colspan='3'>공지 게시판</td>");
				writer.println("<td style='text-align: right'>");
				writer.println("<font size=2>등록된 글이 없습니다.</font>");
				writer.println("</td>");
				writer.println("</tr>");

			}

			writer.println("<tr class='h30 lime center btn'>");
			writer.println(" <td colspan=4 style='text-align: center'>");

			if (page <= 1) {
				writer.println("이전&nbsp;");
			}
		

			if (page > 1) {
				writer.println("<a href='./NTBoardList.nt?page='"+(page-1)+"class='pageBefore'>이전</a>");
			}

			for (int i = startpage; i <=endpage; i++) {
				if (i == page) {
					writer.println(i);
				}

				if (i != page) {
					writer.print("<a href='./NTBoardList.nt?page='"+i+ "class='pageCurrent'>"+i+"</a>");
				}
			}

			
			if (page >= maxpage) {
				writer.println("&nbsp;다음");
			}
			if (page < maxpage) {
				writer.println("<a href='./NTBoardList.nt?page='"+(page+1)+"class='pageAfter'>&nbsp;다음</a>");
			}
			writer.println("</td>");
			writer.println("<td colspan='1' style='text-align: center'>");
			writer.println("<a href='./NTBoardWrite.nt'>[글쓰기]</a>");
			writer.println("</td>");
			writer.println("</tr>");

			writer.println("<input type='hidden' id='page' value="+page+">");
			  
			writer.flush();
			writer.close();

			return null;
			
		}else {
			int listcount = ndao.getListCount();
			boardlist = ndao.getBoardList(listOpt, page, limit, search, searchOpt);
			
			int maxpage =(listcount+limit-1)/limit;
			System.out.println("총 페이지수 = " + maxpage);
			
			int startpage = ((page - 1) / 10) * 10 + 1;
			System.out.println("현재 페이지에 보여줄 시작 페이지 수 = " + startpage);
			
			int endpage = startpage * 10 -1;
			System.out.println("현재 페이지에서 보여줄 마지막 페이지 수 = " + endpage);
			
			if(endpage > maxpage) {
				endpage = maxpage;
			}
			
			request.setAttribute("page", page);
			request.setAttribute("maxpage", maxpage);
			
			request.setAttribute("startpage", startpage);
			
			request.setAttribute("endpage", endpage);
			
			request.setAttribute("listcount", listcount);
			
			request.setAttribute("boardlist", boardlist);
			
			request.setAttribute("opt", opt);
		    request.setAttribute("condition", condition);
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			
			forward.setPath("./board/notice/nt_board_list.jsp");
			
			return forward;
		}
		
	}

}