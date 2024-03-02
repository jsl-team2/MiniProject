package dao.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Action;

public class CertiCheckService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getParameter("utf-8");
		String certinumber = request.getParameter("certinumber");
		
		String authkey = (String) request.getSession().getAttribute("authkey");
		
		Map<String, String> map = new HashMap<String, String>();
		
		Gson gson = new Gson();
		
		if(certinumber.equals(authkey)) {
			map.put("msg", "認証番号が一致します");
			map.put("check", "ok");
		}else {
			map.put("msg", "認証番号が一致しません");
			map.put("check", "nok");
		}
		
		request.getSession().removeAttribute("authkey");
		
		String authjson = gson.toJson(map); 
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().write(authjson);
	}
}
