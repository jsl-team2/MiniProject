package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.ProductDetailService;
import dao.product.ProductListService;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getServletPath();
		String path = null;
		if(command.equals("/main.do") || command.equals("/")) {
			path = "index.jsp";
		}else if(command.equals("/productlist.do")) {
			try {
				new ProductListService().execute(request, response);
				path = "/product/productlist.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productdetail.do")) {
			try {
				new ProductDetailService().execute(request, response);
				path = "/product/productdetail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productbasket.do")) {
			try {
				
				path = "/product/productbasket.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productorder.do")) {
			try {
				
				path = "/product/productorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productordercomplete.do")) {
			try {
				
				path = "/product/productordercomplete.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//  insert구현-제품 데이터 정리 - 기능구현           페이지 디테일 수정          발표?
		
		
		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request,response);
		}
	}
}
