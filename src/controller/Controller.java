package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.ProductCartDeleteService;
import dao.product.ProductCartService;
import dao.product.ProductDetailService;
import dao.product.ProductListService;
import dao.product.ProductOrderOneCompleteService;
import dao.product.ProductOrderOneService;
import dao.product.ProductOrderService;

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
		}else if(command.equals("/productcart.do")) {
			try {
				new ProductCartService().execute(request, response);
				path = "/product/productcart.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productcartdelete.do")) {
			try {
				new ProductCartDeleteService().execute(request, response);
				path = "/product/productcart.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/productorder.do")) {
			try {
				new ProductOrderService().execute(request, response);
				path = "/product/productorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productorderone.do")) {
			try {
				new ProductOrderOneService().execute(request, response);
				path = "/product/productorderone.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/productorderonecomplete.do")) {
			try {
				new ProductOrderOneCompleteService().execute(request, response);
				path = "/product/productordercomplete.jsp";
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
		
		
		// 장바구니 수량
		// 장바구니 삭제 
		// orderone 기능 수정 - 저장테이블 칼럼 확인.
		// 페이징   / 발표?
		// 메뉴 ?
		// 제품 데이터
		// 배송정보 자동입력 //
		// 주문조회 
		// 장바구니 한번에 주문
		
		
		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request,response);
		}
	}
}
