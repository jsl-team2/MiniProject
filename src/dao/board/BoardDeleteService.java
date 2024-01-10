package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class BoardDeleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		//클라이언트로 부터 처리하고자 하는 데이터를 요청
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDao dao = new BoardDao();
		
		dao.getBoardDelet(board_no);

		
	}
}
