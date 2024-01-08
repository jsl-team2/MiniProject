
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

import dao.board.BoardDeleteService;
import dao.board.BoardInsertService;
import dao.board.BoardSearchService;
import dao.board.BoardSelectAll;
import dao.board.BoardUpdateService;
import dao.board.BoardViewService;



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
		}
		
    //board
    //1:1 문의 메인화면 
		 if (command.equals("/board.do")) {
			 try {
				new BoardSelectAll().execute(request, response);
				path="/board/board.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 //1:1 문의 글쓰기
		else if (command.equals("/boardwrite.do")) {
			path="/board/boardwrite.jsp";
		}
		
		 //1:1 문의 글쓰기 INSERT
		else if (command.equals("/boardinsert.do")) {
			try {
				new BoardInsertService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 해당 글 목록
		else if(command.equals("/boardview.do")) {
			try {
				new BoardViewService().execute(request, response);
				path="/board/boardview.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		 //전체 글 list
		else if(command.equals("/boardview.do")) {
			try {
				new BoardViewService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		 //글 삭제
		else if(command.equals("/boarddelete.do")) {
			try {
				new BoardDeleteService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 //수정 하고자 하는 해당 글
		 else if (command.equals("/boardmodify.do")) {
			try {
				new BoardViewService().execute(request, response);
				path = "/board/boardmodify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 //해당 글 수정
		 else if (command.equals("/boardmodifypro.do")) {
			try {
				new BoardUpdateService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 //글 찾기
		 else if (command.equals("/boardsearch.do")) {
			try {
				new BoardSearchService().execute(request, response);
				path = "/board//board.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    
		

		if(command.equals("/search.do")) {
			try {
				new SearchService().execute(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
