<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="db.DBmanager"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB test</title>
</head>
<body>
	<%
		Connection conn = DBmanager.getInstance().getConnection();

	if (conn != null) {
		out.print("접속완료");
	} else {
		out.print("접속실패");
	}
	%>
</body>
</html>
