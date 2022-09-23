package net.board.vb.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.board.vb.db.VBoardDAO;
import net.board.vb.db.VBoardVO;

public class VBoardAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		VBoardDAO vboardDAO=new VBoardDAO();
		VBoardVO vboardData = new VBoardVO();
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
		
			vboardData.setVid(multi.getParameter("vid"));
			vboardData.setVname(multi.getParameter("vname"));
			vboardData.setVpass(multi.getParameter("vpass"));
			vboardData.setVbsub(multi.getParameter("vbsub"));
			vboardData.setVbcont(multi.getParameter("vbcont"));
			vboardData.setVbweek(multi.getParameter("vbweek"));
			vboardData.setVbpostime(multi.getParameter("vbpostime"));
			vboardData.setVbarea(multi.getParameter("vbarea"));
			vboardData.setVbrelig(multi.getParameter("vbrelig"));
			vboardData.setVbchrac(multi.getParameter("vbchrac"));
			vboardData.setVbexper(multi.getParameter("vbexper"));
			vboardData.setVbexcont(multi.getParameter("vbexcont"));
			
			
			vboardData.setVbcerti(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			result=vboardDAO.boardInsert(vboardData);
			
			if(result==false) {
				System.out.println("게시판 등록 실패");
			return null;
			}
			System.out.println("게시판 등록 완료");
			
			forward.setRedirect(true);
			forward.setPath("./vboardList.vb");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
