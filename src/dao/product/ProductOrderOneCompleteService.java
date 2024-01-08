package dao.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderOneCompleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

//		String order_user = "user"; // 로그인 유저

		int order_productno = Integer.parseInt(request.getParameter("product_no"));
		// 수량?

		String order_name = request.getParameter("name");
		String order_tel = request.getParameter("tel");
		String order_address = request.getParameter("address");

		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();

		vo = dao.getProductSelectOne(order_productno); // 상품가져오기
		vo.setOrder_name(order_name);
		vo.setOrder_tel(order_tel);
		vo.setOrder_address(order_address);

//		dao.orderInsert(vo);

	}

}
