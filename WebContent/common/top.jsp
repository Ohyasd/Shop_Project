<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.dto.MemberDTO" %>
    
<%
MemberDTO dto=(MemberDTO)session.getAttribute("login");
if(dto!=null){ //회원인경우
%>
안녕하세요 <%=dto.getUsername() %> <!-- 안녕하세요 , 사용자이름 출력 -->
<a href="LogoutServlet">로그아웃</a>
<a href="MyPageServlet">mypage</a>
<a href="CartListServlet">장바구니</a>

<%
}else{ //비회원인경우
%>

<a href="LoginUIServlet">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<a href="CartListServlet">장바구니</a>
<%
}
%>