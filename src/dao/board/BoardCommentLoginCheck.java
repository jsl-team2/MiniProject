package dao.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Action;

public class BoardCommentLoginCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("user_id");
		
		
		String ajax= request.getHeader("X-requested-with"); //요청이 ajax인지아닌지 
		HttpSession session=request.getSession();   
//		session.setAttribute("userid", id);
//		String user=session.getAttribute("USER_INFO");
//		if(user==null) {
//        	//추가된부분
//			if(ajax!=null) { //ajax요청일 경우
//				response.sendError(401, "로그인안했어요"); //ajax error함수에서 login으로 이동하게 할거임.
//				return false;
//			}
//			
//			response.sendRedirect(request.getContextPath()+"/login.do");
//			return false;
//		}
//		return true;
//		}
	}
}
