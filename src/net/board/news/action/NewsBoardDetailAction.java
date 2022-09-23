package net.board.news.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardDetailAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      NewsBoardDAO dao = new NewsBoardDAO();
      NewsBoardVO detail = new NewsBoardVO();
      NewsBoardVO beforedetail = new NewsBoardVO();
      NewsBoardVO afterdetail = new NewsBoardVO();
      HashMap<String, Object> listOpt = new HashMap<String, Object>();
      
      request.setCharacterEncoding("UTF-8");
      
      int num = Integer.parseInt(request.getParameter("num"));
      System.out.println(num);
      dao.setReadCountUpdate(num);
      
      int beforeNum = num - 1;
      int afterNum = num + 1;
      
      int i = 1, j = 1;
      
      int count = dao.getListCount(listOpt);
      int max = dao.getListMax();
      
      beforedetail = dao.getDetail(beforeNum);
      while(beforedetail == null) {
    	  if((beforeNum - i) <= 0 || beforeNum <= 0) {
    		  break;
    	  }
    	  beforedetail = dao.getDetail(beforeNum - i);
    	  
    	  i = i + 1;
      }
      
      afterdetail = dao.getDetail(afterNum);
      while(afterdetail == null) {
    	  if((afterNum + j) > max || afterNum > max) {
    		  break;
    	  }
    	  afterdetail = dao.getDetail(afterNum + j);
    	  
    	  j = j + 1;
      }
      detail = dao.getDetail(num);
      
      if(detail == null) {
      System.out.println("상세보기 실패");
         return null;
      }
      System.out.println("상세보기 성공");

      request.setAttribute("detail", detail);
      request.setAttribute("beforedetail", beforedetail);
      request.setAttribute("afterdetail", afterdetail);
      request.setAttribute("count", count);
      request.setAttribute("max", max);
      request.setAttribute("num", num);
      ActionForward forward = new ActionForward();
      
      forward.setRedirect(false);
      forward.setPath("./board/news_board/news_board_view.jsp");
      
      return forward;
   }

}