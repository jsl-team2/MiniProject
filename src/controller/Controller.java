package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.BoardCommentDeleteService;
import dao.board.BoardCommentInsertService;
import dao.board.BoardCommentModifyService;
import dao.board.BoardDeleteService;
import dao.board.BoardInsertService;
import dao.board.BoardSearchService;
import dao.board.BoardSelectAll;
import dao.board.BoardUpdateService;
import dao.board.BoardViewService;
import dao.member.CertiCheckService;
import dao.member.EmailSendService;
import dao.member.LoginService;
import dao.member.MemberIdSearchService;
import dao.member.MemberLogoutService;
import dao.member.MemberSaveService;
import dao.product.AdminOrderStatusService;
import dao.product.AdminOrderViewService;
import dao.product.MyOrderCancelService;
import dao.product.MyOrderDetailService;
import dao.product.MyOrderService;
import dao.product.ProductAddService;
import dao.product.ProductCartDeleteService;
import dao.product.ProductCartService;
import dao.product.ProductDeleteService;
import dao.product.ProductDetailService;
import dao.product.ProductListMenuService;
import dao.product.ProductListService;
import dao.product.ProductOrderCompleteService;
import dao.product.ProductOrderOneCompleteService;
import dao.product.ProductOrderOneService;
import dao.product.ProductOrderService;
import dao.product.ProductRecentListService;
import dao.product.ProductSelectAll;
import dao.product.ProductUpdateService;
import dao.product.ProductUpdateView;
import dao.search.SearchService;
import dao.user.UserSelectAll;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getServletPath();
		String path = null;

		// 메인
		if (command.equals("/main.do") || command.equals("/")) {
			try {
				new ProductRecentListService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/index.jsp";

			// 제품목록
		} else if (command.equals("/productlist.do")) {
			try {
				new ProductListService().execute(request, response);
				path = "/product/productlist.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 제품 메뉴별 목록
		} else if (command.equals("/productlistmenu.do")) {
			try {
				new ProductListMenuService().execute(request, response);
				path = "/product/productlistmenu.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 제품상세
		} else if (command.equals("/productdetail.do")) {
			try {
				new ProductDetailService().execute(request, response);
				path = "/product/productdetail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 장바구니
		} else if (command.equals("/productcart.do")) {
			try {
				new ProductCartService().execute(request, response);
				path = "/product/productcart.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 장바구니 내역 삭제
		} else if (command.equals("/productcartdelete.do")) {
			try {
				new ProductCartDeleteService().execute(request, response);
				path = "/product/productcart.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 단일 상품 주문
		} else if (command.equals("/productorderone.do")) {
			try {
				new ProductOrderOneService().execute(request, response);
				path = "/product/productorderone.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 단일 상품 주문 완료
		} else if (command.equals("/productorderonecomplete.do")) {
			try {
				new ProductOrderOneCompleteService().execute(request, response);
				path = "/product/productordercomplete.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 장바구니 상품 주문
		} else if (command.equals("/productordercomplete.do")) {
			try {
				new ProductOrderCompleteService().execute(request, response);
				path = "/product/productordercomplete.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 제품 주문
		} else if (command.equals("/productorder.do")) {
			try {
				new ProductOrderService().execute(request, response);
				path = "/product/productorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 개인 주문 목록
		} else if (command.equals("/myorder.do")) {
			try {
				new MyOrderService().execute(request, response);
				path = "/product/myorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myordercancel.do")) {
			try {
				new MyOrderCancelService().execute(request, response);
				path = "/product/myorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 개인 주문 상세
		} else if (command.equals("/myorderdetail.do")) {
			try {
				new MyOrderDetailService().execute(request, response);
				path = "/product/myorderdetail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 관리자 주문 목록
		} else if (command.equals("/adminorder.do")) {
			try {
				new AdminOrderViewService().execute(request, response);
				path = "/product/adminorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 관리자 주문 상세
		} else if (command.equals("/adminorderdetail.do")) {
			try {
				new MyOrderDetailService().execute(request, response);
				path = "/product/adminorderdetail.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 주문상태 수정
		else if (command.equals("/adminorderstatus.do")) {
			try {
				new AdminOrderStatusService().execute(request, response);
				path = "/product/adminorder.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// board
		// 1:1 문의 메인화면
		if (command.equals("/board.do")) {
			try {
				new BoardSelectAll().execute(request, response);
				path = "/board/board.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 1:1 문의 글쓰기
		else if (command.equals("/boardwrite.do")) {
			path = "/board/boardwrite.jsp";
		}

		// 1:1 문의 글쓰기 INSERT
		else if (command.equals("/boardinsert.do")) {
			try {
				new BoardInsertService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 해당 글 목록
		else if (command.equals("/boardview.do")) {
			try {
				new BoardViewService().execute(request, response);
				path = "/board/boardview.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 전체 글 list
		else if (command.equals("/boardview.do")) {
			try {
				new BoardViewService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 글 삭제
		else if (command.equals("/boarddelete.do")) {
			try {
				new BoardDeleteService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 수정 하고자 하는 해당 글
		else if (command.equals("/boardmodify.do")) {
			try {
				new BoardViewService().execute(request, response);
				path = "/board/boardmodify.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 해당 글 수정
		else if (command.equals("/boardmodifypro.do")) {
			try {
				new BoardUpdateService().execute(request, response);
				response.sendRedirect("/board.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 글 찾기
		else if (command.equals("/boardsearch.do")) {
			try {
				new BoardSearchService().execute(request, response);
				path = "/board/board.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 댓글 글 쓰기
		else if (command.equals("/commentinsert.do")) {
			try {
				new BoardCommentInsertService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 댓글 삭제
		else if (command.equals("/commentdelete.do")) {
			try {
				new BoardCommentDeleteService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 댓글 수정
		else if (command.equals("/commentmodify.do")) {
			try {
				new BoardCommentModifyService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (command.equals("/search.do")) {

			try {
				new SearchService().execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "search.jsp";
		} else if (command.equals("/admin.do")) {
			try {
				new UserSelectAll().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/admin/admin.jsp";
		} else if (command.equals("/usersearch.do")) {
			try {
				new UserSelectAll().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/admin/admin.jsp";
		} else if (command.equals("/productmanagement.do")) {
			try {
				new ProductSelectAll().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/admin/productmanagement.jsp";
		} else if (command.equals("/productsearch.do")) {
			try {
				new ProductSelectAll().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			path = "/admin/productmanagement.jsp";
		} else if (command.equals("/productadd.do")) {
			path = "/admin/productadd.jsp";
		} else if (command.equals("/productaddpro.do")) {
			try {
				new ProductAddService().execute(request, response);
				response.sendRedirect("/productmanagement.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("/productdelete.do")) {
			try {
				new ProductDeleteService().execute(request, response);
				response.sendRedirect("/productmanagement.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/productupdateview.do")) {
			try {
				new ProductUpdateView().execute(request, response);
				path = "/admin/productupdate.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/productupdate.do")) {
			try {
				new ProductUpdateService().execute(request, response);
				response.sendRedirect("/productmanagement.do");
			} catch (Exception e) {
			}
		} else if (command.equals("/terms.do")) {
			// 무작위의 문자 생성
			char ran = (char) ((Math.random() * 26) + 65); // 대문자 65 소문자 97
			request.setAttribute("alpa", ran);
			path = "/member/terms.jsp";
		}

		else if (command.equals("/join.do")) {
			path = "/member/join.jsp";
		} else if (command.equals("/joinpro.do")) {
			// 속성에 담아서 넘겨야 안보임
			try {
				new MemberSaveService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String chk = request.getParameter("check");
			System.out.println(chk);
			request.setAttribute("check", chk);
			path = "/member/login.jsp";

		} else if (command.equals("/emailsend.do")) {
			try {
				new EmailSendService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberidcheck.do")) {
			try {
				new MemberIdSearchService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/certinumber.do")) {
			try {
				new CertiCheckService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (command.equals("/memberwrite.do")) {
			try {
				new MemberSaveService().execute(request, response);
				response.sendRedirect("index.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/login.do")) {
			path = "/member/login.jsp";
		} else if (command.equals("/loginpro.do")) {
			try {
				new LoginService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/logout.do")) {
			try {
				new MemberLogoutService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}
	}
}
