package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import dao.BoardVo;

public class BoardUpdateService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		BoardVo vo = new BoardVo();

		vo.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		vo.setBoard_title(request.getParameter("title"));
		vo.setBoard_content(request.getParameter("content"));

		BoardDao dao = new BoardDao();

		dao.setBoardUpdate(vo);

	}

}
