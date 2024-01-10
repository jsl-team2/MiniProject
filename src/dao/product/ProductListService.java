package dao.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class ProductListService implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		ProductDao dao = new ProductDao();
		List<ProductVo> list = dao.getProductSelectAll();
		
		request.setAttribute("list", list);
		
	}
	
}

