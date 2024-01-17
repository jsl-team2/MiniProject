package dao.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class BoardSelectAll implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		int pageNum = 1;
		int amount = 10;
		String type = "board_title";
		String keyword = "";

		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // 페이지 번호
			amount = Integer.parseInt(request.getParameter("amount")); // 페이지번호에 해당하는 출력 래코드 개수
		}

		if (request.getParameter("type") != null && !request.getParameter("keyword").equals("")) {
			type = request.getParameter("type");
			keyword = request.getParameter("keyword");
		}

		BoardDao dao = new BoardDao();
		Criteria cri = new Criteria();

		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		cri.setType(type);
		cri.setKeyword(keyword);

		List<BoardVo> list = dao.getListSetWithPaging(cri); //페이지에 해당하는 10개 레코드 검색
		int total = dao.getBoardSerchCount(cri); //총 레코드 검색
		
		PageDto dto = new PageDto(cri, total);

		request.setAttribute("page", dto);
		
		request.setAttribute("Blist", list);
		request.setAttribute("total", total);

		
	}
}
