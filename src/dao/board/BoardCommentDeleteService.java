package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class BoardCommentDeleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		String board_no = request.getParameter("board_no");
		
		BoardDao dao = new BoardDao();
		
		dao.getCommentDelet(comment_no);
		
		response.sendRedirect("/boardview.do?board_no="+board_no);
	}
}
