package dao.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import org.json.simple.JSONArray;

import dao.Action;

public class BoardLoadMoreComments implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		
//		 int startIndex = Integer.parseInt(request.getParameter("startIndex"));
//
//		    // 데이터베이스에서 추가 댓글을 가져옵니다.
//		    List<CommentVo> comments = commentService.getComments(startIndex);
//
//		    // 응답 데이터를 형식화합니다.
//		    JSONArray jsonArray = new JSONArray();
//		    for (CommentVo comment : comments) {
//		      jsonArray.add(comment.toJSON());
//		    }
//
//		    // 응답을 보냅니다.
//		    response.setContentType("application/json");
//		    response.getWriter().write(jsonArray.toString());

	}

}
