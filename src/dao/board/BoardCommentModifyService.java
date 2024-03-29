package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class BoardCommentModifyService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String board_no = request.getParameter("board_no");

		CommentVo vo = new CommentVo();

		vo.setComment_no(Integer.parseInt(request.getParameter("comment_no")));
		vo.setComment_content(request.getParameter("reContent"));
		vo.setComment_createdate(request.getParameter("redate"));
		vo.setComment_secret(Integer.parseInt(request.getParameter("comment_secret")));
		System.out.println(vo.getComment_secret());
		BoardDao dao = new BoardDao();

		dao.setCommentUpdate(vo);
		
		response.sendRedirect("/boardview.do?board_no="+board_no);

		
	}

}
