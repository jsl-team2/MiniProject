package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class ProductSelectAll implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		int pageNum = 1;
		int amount = 10;
		String type = "product_name";
		String keyword = "";
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}

		if(request.getParameter("type") != null && 
				!request.getParameter("keyword").equals("")) {
			type = request.getParameter("type");
			keyword = request.getParameter("keyword");
		}
		ProductDao dao = new ProductDao();
		Criteria cri = new Criteria();
		
		cri.setPageNum(pageNum); //페이지 번호
		cri.setAmount(amount); //페이지 번호에 해당하는 출력 레코드 개수
		cri.setType(type);
		cri.setKeyword(keyword);
		
//		List<NoticeVo> list = dao.getNotice();
		List<ProductVo> list = dao.getListWithPaging(cri); // 페이지에 해당하는 10개 레코드 검색
		int tot = dao.getUserCount(cri); // 총 레코드 개수
		
		PageDto dto = new PageDto(cri,tot);
		
		request.setAttribute("page", dto);
		request.setAttribute("list",list);
		request.setAttribute("tot",tot);
		
	}
}
