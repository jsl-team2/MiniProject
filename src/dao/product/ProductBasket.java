package dao.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductBasket implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		
		ProductDao dao = new ProductDao();
		ProductVo vo = dao.getProductSelectOne(product_no);
		dao.setBasket(vo);
		/// 인설트 확인하고 불러오기 진행
		
		request.setAttribute("vo", vo);
		
	}
	
}

