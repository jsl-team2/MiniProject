package dao.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class UserSearchService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String subject = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		System.out.println(subject);
		System.out.println(keyword);
		UserDao dao = new UserDao();
		List<UserVo> userSearchList = dao.userSearch(subject, keyword);
		
		request.setAttribute("userSearchList", userSearchList);

	}

}
