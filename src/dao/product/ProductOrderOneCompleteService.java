package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderOneCompleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

//		String order_user = "user"; // 로그인 유저

		int order_productno = Integer.parseInt(request.getParameter("product_no"));
		int cart_quantity = 1;
		if(request.getParameter("quantity") != "") {
			cart_quantity = Integer.parseInt(request.getParameter("quantity"));
		}

		String order_name = request.getParameter("name");
		String order_tel = request.getParameter("tel");
		String order_address = request.getParameter("address");

		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();

		vo = dao.getProductSelectOne(order_productno); 
		
		vo.setCart_quantity(cart_quantity);
		int price = vo.getProduct_price();
		price = price * cart_quantity;
		vo.setCart_price(price);
		
		vo.setOrder_name(order_name);
		vo.setOrder_tel(order_tel);
		vo.setOrder_address(order_address);
		
		dao.orderInsert(vo);
		int orderdetail_orderno = dao.getOrderNo();
		vo.setOrderdetail_orderno(orderdetail_orderno);
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo);
		dao.orderdetailInsert(list);
		
		request.setAttribute("orderno", orderdetail_orderno);

	}

}
