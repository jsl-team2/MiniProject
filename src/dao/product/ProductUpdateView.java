package dao.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductUpdateView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ProductDao dao = new ProductDao();
		int product_no = Integer.parseInt(request.getParameter("product_no"));

		ProductVo vo = dao.getProductSelectOne(product_no);
		
		request.setAttribute("vo", vo);
	}

}
