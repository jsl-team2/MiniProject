package dao.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductDeleteService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		
		ProductDao dao = new ProductDao();
		dao.deleteProduct(product_no);
	}

}
