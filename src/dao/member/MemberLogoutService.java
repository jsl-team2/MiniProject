package dao.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Action;

public class MemberLogoutService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		session.removeAttribute("user_id"); //userid 세션 속성만 삭제 
		String user_id = (String)request.getSession().getAttribute("user_id");
		if(user_id == null) {
			System.out.println("로그아웃 성공");
		}else {
			System.out.println("로그아웃 실패");
		}
		session.invalidate(); // 모든 세션 속성 삭제 
		response.sendRedirect("main.do");
		
		
		
	}
}
