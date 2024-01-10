package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.MyOrderService;
import dao.product.ProductCartDeleteService;
import dao.product.ProductCartService;
import dao.product.ProductDetailService;
import dao.product.ProductListMenuService;
import dao.product.ProductListService;
import dao.product.ProductOrderCompleteService;
import dao.product.ProductOrderOneCompleteService;
import dao.product.ProductOrderOneService;
import dao.product.ProductOrderService;

import dao.search.SearchService;


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
		}else if(command.equals("/productlistmenu.do")) {
			try {
				new ProductListMenuService().execute(request, response);
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
				new ProductOrderCompleteService().execute(request, response);
				path = "/product/productordercomplete.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/myorder.do")) {
			try {
				new MyOrderService().execute(request, response);
				path = "/product/myorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
//		1. 오류해결
//		select * from tbl_order where order_id='user';
//		주문번호 / 받는사람 / 주소 / 날짜 / 상태 / 주문상세
//		양식에 화면구현
//		개인주문 완성 - 버튼추가 - 
//
//		select * from tbl_orderdetail where orderdetail_orderno = ?;

		
		
		// 개인주문조회
		// order select 맨위
		// 주문번호에 해당하는 orderdeltail select
		
		// 관리자주문조회
		// order select all // 주문상세 버튼 클릭하면 주문번호 넘기고 주문상세 출력
		
		// 로그인 연결
		
		// 제품 데이터 정리, db정리
		 
		// 발표준비 ppt
		// 역할 / 준비과정 / 요구사항분석 / 사용툴 / 와이어프레임  / db설계 / 1차 / 2차 / 코드합치고 오류수정 및 디자인수정
		// 영상 / 
		
		
		if(command.equals("/search.do")) {
			try {
				new SearchService().execute(request, response);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "search.jsp";
		}

		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request,response);
		}
	}
}
