package dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductOrderService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String user = "user";
//		String user = request.getParameter("cart_user");
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductDao dao = new ProductDao();
		
		list = dao.getCartAll(user);
		
		ProductVo vo = dao.getUserInfo(); // 배송정보
		
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		
	}
	
}

