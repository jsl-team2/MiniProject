package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class MyOrderDetailService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int order_no = Integer.parseInt(request.getParameter("order_no"));
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();
		
		vo = dao.getMyOrderOne(order_no);
		list = dao.getMyOrderDetail(order_no);
		
		request.setAttribute("vo", vo);
		request.setAttribute("list", list);
		
	}
	
}

