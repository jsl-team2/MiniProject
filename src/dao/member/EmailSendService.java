package dao.member;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.Action;

public class EmailSendService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		
		String email = request.getParameter("email");
		System.out.println(email);
		
		MemberDao dao = new MemberDao();
		String auth = dao.emailSend(email, request, response);
		
		HttpSession authkey = request.getSession(); //세선객체 생성 
		authkey.setAttribute("authkey", auth);
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "메일전송 성공");
		map.put("check", "ok");
		
		Gson gson = new Gson();
	
		String aaa = gson.toJson(map); //map객체를 json형식으로 변환 
		System.out.println(aaa.toString());
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.write(aaa.toString());  //문자열로 변환하여 클라이언트로 리턴 한다 
		
		
		
	}

}
