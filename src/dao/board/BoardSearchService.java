package dao.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;

public class BoardSearchService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getBoardSearch(type, keyword);
		
		request.setAttribute("list", list);
		Criteria cri = new Criteria();
		
		int total = dao.getBoardSerchCount(cri);
		request.setAttribute("total", total);
		
		
	}

}
