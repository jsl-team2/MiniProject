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
		
		String user_id = request.getParameter("user_id");
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		ProductDao dao = new ProductDao();
		
		list = dao.getCartAll(user_id);
		
		ProductVo vo = dao.getUserInfo(user_id); 
		
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		
	}
	
}

