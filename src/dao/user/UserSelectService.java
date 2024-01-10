package dao.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class UserSelectService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		UserDao dao = new UserDao();
		List<UserVo> list = dao.userSelectAll();
		
		
		request.setAttribute("list", list);
		
	}

}
