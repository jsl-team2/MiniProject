package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.product.ProductDetailService;
import dao.product.ProductListService;
import dao.product.ProductRecentListService;
import dao.search.SearchService;
import dao.user.UserSearchService;
import dao.user.UserSelectAll;
import dao.user.UserSelectService;


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
			try {
				new ProductRecentListService().execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/index.jsp";
			
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
		}else if(command.equals("/search.do")) {
			try {
				new SearchService().execute(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path = "search.jsp";
		}else if(command.equals("/admin.do")) {
			try {
				new UserSelectAll().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path="/admin/admin.jsp";
		}else if(command.equals("/usersearch.do")) {
			try {
				new UserSelectAll().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path="/admin/admin.jsp";
		}else if(command.equals("/admin/membercheck.do")) {
			path="/admin/membercheck.jsp";
		}
		

		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request,response);
		}
	}
}
