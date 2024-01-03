package dao.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class SearchService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String keyword = null;
		
		keyword = request.getParameter("keyword");
		
		SearchDao dao = new SearchDao();
		List<SearchVo> productList = dao.getSearchProduct(keyword);
		List<SearchVo> boardList = dao.getSearchBoard(keyword);
		request.setAttribute("productList",productList);
		request.setAttribute("boardList",boardList);
		request.setAttribute("keyword", keyword);
	}

}
