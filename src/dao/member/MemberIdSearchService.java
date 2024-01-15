package dao.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class MemberIdSearchService implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      
      String id = request.getParameter("id");
      
      MemberDao dao = new MemberDao();  
      int result = dao.getIdSearch(id);
      
      PrintWriter out = response.getWriter();
      out.print(result);
      
   }

}