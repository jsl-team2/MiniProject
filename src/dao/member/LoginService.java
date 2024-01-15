package dao.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Action;
import utility.SecurityPassword;

public class LoginService implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        request.setCharacterEncoding("utf-8");
         
        String id = request.getParameter("id");
        String pw = SecurityPassword.encoding(request.getParameter("pw"));
         
        MemberDao dao = new MemberDao();
        int loginResult = dao.getMemberLogin(id, pw);
         
        if(loginResult == 1) {
          HttpSession session = request.getSession();
          session.setAttribute("user_id", id);
          session.setAttribute("login_msg", "로그인이 완료되었습니다.");
          session.setMaxInactiveInterval(30 * 60); // 세션 유효 시간 30분 설정
          response.sendRedirect("index.do");
        } else if(loginResult == 0) {
          request.setAttribute("msg", "존재하지 않는 사용자입니다.");
          RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
          rd.forward(request, response);
        } else if(loginResult == -1) {
          request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
          RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
          rd.forward(request, response);
        }
      }

    }