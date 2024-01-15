<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel ="stylesheet" href="css/mystyle.css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



		<div class="paging">
						
			
			<c:forEach var="num" begin="${page.startPage }"	end="${page.endPage }">
				<a href="boardview.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"
					class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
			</c:forEach>
			
			
		</div>