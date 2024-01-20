package dao.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class ProductListMenuService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String keyword = request.getParameter("keyword");
		int pageNum = 1;
		int amount = 6;
		
		Criteria cri = new Criteria();
		ProductDao dao = new ProductDao();
		
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		if (!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
		}

		cri.setPageNum(pageNum); // 페이지 번호
		cri.setAmount(amount); // 페이지 번호에 해당하는 출력 레코드 개수
		cri.setKeyword(keyword);

		List<ProductVo> list = dao.getProductMenuWithPaging(cri); // 페이지에 해당하는 10개 레코드 검색
		int tot = dao.getProductMenuCount(cri); // 총 레코드 개수

		PageDto dto = new PageDto(cri, tot);
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("list", list);
		request.setAttribute("page", dto);
		request.setAttribute("tot", tot);

	}

}
