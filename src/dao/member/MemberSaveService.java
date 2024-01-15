package dao.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import dao.Action;
import utility.SecurityPassword;

public class MemberSaveService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = SecurityPassword.encoding(request.getParameter("pw"));
		String name = request.getParameter("name");
		
		System.out.println(request.getParameter("phone1"));
		System.out.println(request.getParameter("phone2"));
		System.out.println(request.getParameter("phone3"));
		
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		
		
		String email = request.getParameter("email");
		
		
		
		String sample6_postcode = request.getParameter("sample6_postcode");
		String sample6_address = request.getParameter("sample6_address");
		String sample6_detailAddress = request.getParameter("sample6_detailAddress");
		String sample6_extraAddress = request.getParameter("sample6_extraAddress");
		
		String address = sample6_postcode+sample6_address+sample6_detailAddress+sample6_extraAddress;
		
		String phone5 = phone1 + phone2 + phone3; 
		
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(phone3);
		
		
		ProjectVo vo = new ProjectVo();
		
		vo.setUser_id(id);
		vo.setUser_pw(pw);
		vo.setUser_name(name);
		vo.setUser_phone(phone5);
		vo.setUser_email(email);
		vo.setUser_address(address);
		
		MemberDao dao = new MemberDao();
		
		dao.setMemberSave(vo);
		
	}

}
