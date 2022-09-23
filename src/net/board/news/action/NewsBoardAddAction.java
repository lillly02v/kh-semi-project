package net.board.news.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.board.news.db.NewsBoardDAO;
import net.board.news.db.NewsBoardVO;

public class NewsBoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NewsBoardDAO dao = new NewsBoardDAO();
		NewsBoardVO boardData = new NewsBoardVO();
		ActionForward forward = new ActionForward();
		String realFolder = "";
		
		String saveFolder = "boardupload";
		
		int filesize = 5 * 1024 * 1024;
		//실체 저장경로 지정
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		
		System.out.println("realFolder : " + realFolder);
		
		boolean result = false;
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, filesize, 
									"utf-8", new DefaultFileRenamePolicy());
			boardData.setAname(multi.getParameter("aname"));
			boardData.setNesub(multi.getParameter("nesub"));
			boardData.setNecont(multi.getParameter("necont"));
			boardData.setNefiles(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			result = dao.boardInsert(boardData);
			
			//글 등록에 실패할 경우 null을 반환합니다.
			if(result == false) {
				System.out.println("게시판 등록 실패");
				return null;
			}
			System.out.println("게시판 등록 완료");
			
			//글 등록이 완료되면 글 목록을 단순히 보여주기만 할 것이므로
			//Redirect여부를 true로 설정합니다.
			forward.setRedirect(true);
			//이동할 경로를 지정합니다.
			forward.setPath("./news_board_album.news");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
