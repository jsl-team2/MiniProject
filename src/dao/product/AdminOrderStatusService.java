package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class AdminOrderStatusService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String order_status = request.getParameter("selectedValueHidden");
		int order_no = Integer.parseInt(request.getParameter("selectedOrderNo"));
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductDao dao = new ProductDao();
		
		dao.setAdminOrderStatus(order_no, order_status);
		
		Criteria cri = new Criteria();

		int pageNum = 1;
		int amount = 10;

		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}

		cri.setPageNum(pageNum); // 페이지 번호
		cri.setAmount(amount); // 페이지 번호에 해당하는 출력 레코드 개수

		list = dao.getAdminOrderWithPaging(cri); // 페이지에 해당하는 10개 레코드 검색
		int tot = dao.getAdminOrderCount(cri); // 총 레코드 개수

		PageDto dto = new PageDto(cri, tot);

		request.setAttribute("list", list);
		request.setAttribute("page", dto);
		request.setAttribute("tot", tot);
		
	}
	
}

