package dao.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderCompleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String user = "user"; // 로그인 유저

		String order_name = request.getParameter("name");
		String order_tel = request.getParameter("tel");
		String order_address = request.getParameter("address");

		ProductVo vo = new ProductVo();
		vo.setOrder_name(order_name);
		vo.setOrder_tel(order_tel);
		vo.setOrder_address(order_address);
		
		ProductDao dao = new ProductDao();
		dao.orderInsert(vo);
		int orderdetail_orderno = dao.getOrderNo();
		vo.setOrderdetail_orderno(orderdetail_orderno);
		
		List<ProductVo> list = dao.getCartAll(user);
		
		for(ProductVo votmp : list) {
			votmp.setOrderdetail_orderno(orderdetail_orderno);
		}
		
		dao.orderdetailAllInsert(list);
		
		request.setAttribute("orderno", orderdetail_orderno);
		
		dao.cartDelete(user);
		
	}

}
