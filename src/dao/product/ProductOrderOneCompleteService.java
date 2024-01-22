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

		String user_id = request.getParameter("user_id");
		String order_name = request.getParameter("editableName");
		String order_tel = request.getParameter("editableTel"); 

		int order_productno = Integer.parseInt(request.getParameter("product_no"));
		int cart_quantity = 1;
		if(request.getParameter("quantity") != "") {
			cart_quantity = Integer.parseInt(request.getParameter("quantity"));
		}

		String order_address = null;
		String sample6_postcode = null;
		String sample6_address = null;
		String sample6_detailAddress = null;
		String sample6_extraAddress = null;
		if(request.getParameter("editableAddress") != "") {
			order_address = request.getParameter("editableAddress");
		}else {
			sample6_postcode = request.getParameter("sample6_postcode");
			sample6_address = request.getParameter("sample6_address");
			order_address = sample6_postcode+sample6_address;
			if(request.getParameter("sample6_detailAddress") != null) {
				sample6_detailAddress = request.getParameter("sample6_detailAddress");
				order_address += sample6_detailAddress;
			}
			if(request.getParameter("sample6_extraAddress") != null) {
				sample6_extraAddress = request.getParameter("sample6_extraAddress");
				order_address += sample6_extraAddress;
			}
		}
		
		ProductVo vo = new ProductVo();
		vo.setOrder_name(order_name);
		vo.setOrder_tel(order_tel);
		vo.setOrder_address(order_address);
		
		ProductDao dao = new ProductDao();

		vo = dao.getProductSelectOne(order_productno); 
		
		vo.setCart_quantity(cart_quantity);
		int price = vo.getProduct_price();
		price = price * cart_quantity;
		vo.setCart_price(price);
		
		vo.setOrder_name(order_name);
		vo.setOrder_tel(order_tel);
		vo.setOrder_address(order_address);
		
		dao.orderInsert(vo, user_id);
		int orderdetail_orderno = dao.getOrderNo(user_id);
		vo.setOrderdetail_orderno(orderdetail_orderno);
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(vo);
		dao.orderdetailInsert(list);
		
		request.setAttribute("orderno", orderdetail_orderno);

	}

}
