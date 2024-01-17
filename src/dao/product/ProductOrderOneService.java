package dao.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderOneService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		int product_no = Integer.parseInt(request.getParameter("product_no"));
		int cart_quantity = 1;
		if(request.getParameter("quantity") != "") {
			cart_quantity = Integer.parseInt(request.getParameter("quantity"));
		}
			
		String user_id = request.getParameter("user_id");

		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();

		vo = dao.getProductSelectOne(product_no); // 상품가져오기
		vo.setCart_quantity(cart_quantity);
		
		int price = vo.getProduct_price();
		int totPrice = price * cart_quantity;
		
		vo.setProduct_price(totPrice);
		
		//배송정보 가져오기
		ProductVo vo2 = dao.getUserInfo(user_id);
		
		request.setAttribute("vo", vo);
		request.setAttribute("vo2", vo2);
		
		
	}

}
