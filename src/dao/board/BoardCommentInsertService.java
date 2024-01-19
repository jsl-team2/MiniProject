package dao.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommentInsertService {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		CommentVo vo = new CommentVo();
		
		String board_no = request.getParameter("board_no");
		String content = request.getParameter("content");
		String id = request.getParameter("comment_id");
		int secret = Integer.parseInt(request.getParameter("comment_secret"));
		
		vo.setBoard_no(Integer.parseInt(board_no));
		vo.setComment_content(content);
		vo.setComment_id(id);
		vo.setComment_secret(secret);
		
		BoardDao dao = new BoardDao();
		 
		dao.CommentInsert(vo);
		 
		response.sendRedirect("/boardview.do?board_no="+board_no);
			
			
		 
	}
	
}
