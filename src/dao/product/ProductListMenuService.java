package dao.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductListMenuService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String keyword = request.getParameter("keyword");
		
		ProductDao dao = new ProductDao();
		List<ProductVo> list = dao.getProductMenu(keyword);
		
		request.setAttribute("list", list);
		
	}
	
}

