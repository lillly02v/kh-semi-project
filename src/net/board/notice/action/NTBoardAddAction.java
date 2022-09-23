package net.board.notice.action;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import net.board.notice.db.NTBoardDAO;

import net.board.notice.db.NTBoardVO;


public class NTBoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NTBoardDAO ndao=new NTBoardDAO();
		NTBoardVO boardData = new NTBoardVO();
		ActionForward forward = new ActionForward();
		
		String realFolder = "";
		
		String saveFolder = "boardupload";
		
		int fileSize = 5 * 1024 * 1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		
		System.out.println("realFolder : " + realFolder);
		
		boolean result = false;
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request,
					realFolder, fileSize, "UTF-8",
					new DefaultFileRenamePolicy());
			
			boardData.setAname(multi.getParameter("ANAME"));
			boardData.setNtsub(multi.getParameter("NTSUB"));
			boardData.setNtcont(multi.getParameter("NTCONT"));
			
			boardData.setNtfiles(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			
			result = ndao.boardInsert(boardData);
			
			if(result == false) {
				System.out.println("게시판 등록 실패");
				return null;
			}
			System.out.println("게시판 등록 완료");
			
			forward.setRedirect(true);
			
			forward.setPath("./NTBoardList.nt");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
