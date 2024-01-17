package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductCartDeleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		int product_no = Integer.parseInt(request.getParameter("product_no"));
		String user_id = request.getParameter("user_id");
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductDao dao = new ProductDao();

		dao.cartDelete(product_no, user_id);

		String user = "user";
		list = dao.getCartAll(user); // 장바구니 가져오기

		request.setAttribute("list", list);

	}

}
