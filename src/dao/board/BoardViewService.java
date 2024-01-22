package dao.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class BoardViewService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		BoardDao dao = new BoardDao();

		int Board_no = Integer.parseInt(request.getParameter("board_no"));

		
		List<CommentVo> list = dao.getCommentSelect(Board_no);
		
		
		BoardVo vo = dao.getAll(Board_no);
		BoardVo prev = dao.getPrevNoticeNo(Board_no);
		BoardVo next = dao.getNextNoticeNo(Board_no);

		
		request.setAttribute("Clist", list);

		request.setAttribute("view", vo);
		
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

	}

}
