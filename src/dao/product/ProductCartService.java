package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductCartService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductVo vo = new ProductVo();
		ProductDao dao = new ProductDao();
		
		vo = dao.getProductSelectOne(product_no); // 상품가져오기

		int quantityPlus = dao.getCartCheck(product_no);// 장바구니에 같은 상품있는지 확인
		quantity += quantityPlus;
		
		if(quantityPlus == 0) {
			dao.cartInsert(vo, quantity); 
		} else {
			dao.cartDelete(product_no);
			dao.cartInsert(vo, quantity);
		}
		
		String user = "user";
		list = dao.getCartAll(user); // 장바구니 가져오기
		
		request.setAttribute("list", list);
		
	}
	
}

