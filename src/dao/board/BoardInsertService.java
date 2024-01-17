package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class BoardInsertService implements Action {

	// 1:1 문의 Insert 시작 //
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		BoardVo vo = new BoardVo();
		 
		 vo.setBoard_title(request.getParameter("title"));
		 vo.setBoard_writer(request.getParameter("writer"));
		 vo.setBoard_content(request.getParameter("content"));
		 
		BoardDao dao = new BoardDao();
		 
		 dao.BoardInsert(vo);
	}
	
	
	
	
}
