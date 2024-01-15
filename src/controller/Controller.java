package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.member.CertiCheckService;
import dao.member.EmailSendService;
import dao.member.LoginService;
import dao.member.MemberIdSearchService;
import dao.member.MemberSaveService;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String command = request.getServletPath();
		System.out.println(command);
		String path = null;

		if (command.equals("/index.do") || command.equals("/")) {
			path = "/member/index.jsp";

		}

		else if (command.equals("/terms.do")) {
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
		}
		else if (command.equals("/memberidcheck.do")) {
			try {
				new MemberIdSearchService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		else if (command.equals("/certinumber.do")) {
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
		}
	  else if(command.equals("/login.do")) {
	    	path = "/member/login.jsp";
	      }else if(command.equals("/loginpro.do")) {
	      	try {
	      		new LoginService().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	      	
	      }
            // 예외 처리: 로깅 또는 에러 페이지로 리다이렉트
        
		//} else if (command.equals("/logout.do")) {
			//	new MemberLogoutService().execute(request, response);
		//} catch (Exception e) {
		//		e.printStackTrace();
		//	}

	
	if (path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}

	}
}

