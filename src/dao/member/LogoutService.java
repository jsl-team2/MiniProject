package dao.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.SecurityPassword;

public class LogoutService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = SecurityPassword.encoding(request.getParameter("pw"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("addrss");

		
		ProjectVo vo = new ProjectVo();
		vo.setUser_email(email);
		vo.setUser_id(id);
		vo.setUser_name(name);
		vo.setUser_pw(pw);
		vo.setUser_phone(tel);
		vo.setUser_address(address);
		
		MemberDao dao = new MemberDao();
		dao.setMemberSave(vo);
		
	}
}
