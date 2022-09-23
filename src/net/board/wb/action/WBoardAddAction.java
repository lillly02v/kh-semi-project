package net.board.wb.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.board.wb.db.WBoardDAO;
import net.board.wb.db.WBoardVO;

public class WBoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WBoardDAO wboardDAO=new WBoardDAO();
		WBoardVO wboardData = new WBoardVO();
		ActionForward forward = new ActionForward();
		
		String realFolder ="";
		
		String saveFolder="boardupload";
		
		int fileSize =5*1024*1024;
		
		ServletContext sc= request.getServletContext();
		realFolder=sc.getRealPath(saveFolder);
		
		System.out.println("realFolder: " + realFolder);
		
		boolean result=false;
		try {
			MultipartRequest multi =null;
			multi=new MultipartRequest(request,realFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());
		
			wboardData.setWid(multi.getParameter("wid"));
			wboardData.setWname(multi.getParameter("wname"));
			wboardData.setWpass(multi.getParameter("wpass"));
			wboardData.setWbsub(multi.getParameter("wbsub"));
			wboardData.setWbcont(multi.getParameter("wbcont"));
			String[] wbweeks = multi.getParameterValues("wbweek");
			String wbweek = "";
			for(int i = 0; i < wbweeks.length; i++) {
				System.out.println(wbweeks[i]);
				wbweek += (wbweeks[i] + " ");
				System.out.println(wbweek);
			}
			wboardData.setWbweek(wbweek);
			String[] wbpostimes=multi.getParameterValues("wbpostime");
			String wbpostime="";
			for(int i=0; i< wbpostimes.length;i++) {
				wbpostime+=(wbpostimes[i]+" ");
			}
			wboardData.setWbpostime(wbpostime);
			wboardData.setWbarea(multi.getParameter("wbarea"));
			wboardData.setWbrelig(multi.getParameter("wbrelig"));
			wboardData.setWbgenv(multi.getParameter("wbgenv"));
			wboardData.setWbhope(multi.getParameter("wbhope"));
			wboardData.setWbhopeve(multi.getParameter("wbhopeve"));
			
			
			wboardData.setWbfile(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			result=wboardDAO.boardInsert(wboardData);
			
			if(result==false) {
				System.out.println("게시판 등록 실패");
			return null;
			}
			System.out.println("게시판 등록 완료");
			
			forward.setRedirect(true);
			forward.setPath("./wboardList.wb");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
