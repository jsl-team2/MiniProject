<%@page import="dao.Project.ProjectDao"%>
<%@page import="dao.Project.ProjectVo"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.Project.*" %>   
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
<%
request.setCharacterEncoding("utf-8");

String user_id = request.getParameter("user_id");
String user_pw = request.getParameter("user_pw");
String user_name = request.getParameter("user_name");
String user_phone = request.getParameter("user_phone");
String user_email = request.getParameter("user_email");
String user_address = request.getParameter("user_address");


ProjectVo vo = new ProjectVo();


vo.setUser_id(user_id);
vo.setUser_pw(user_pw);
vo.setUser_name(user_name);
vo.setUser_phone(user_phone);
vo.setUser_email(user_email);
vo.setUser_address(user_address);

ProjectDao dao = new ProjectDao();
dao.ProjectInsert(vo);


response.sendRedirect("singup.jsp");
%>   	