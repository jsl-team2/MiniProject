package dao.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderOneService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		int product_no = Integer.parseInt(request.getParameter("product_no"));

//		String user = request.getParameter("cart_user");

		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();

		vo = dao.getProductSelectOne(product_no); // 상품가져오기

		request.setAttribute("vo", vo);

	}

}
