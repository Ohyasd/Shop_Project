package com.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberUIServlet
 */
@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//데이터 파싱 후 memberDTO생성
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
	String username=request.getParameter("username");
	String post=request.getParameter("post");
	String addr1=request.getParameter("addr1");
	String addr2=request.getParameter("addr2");
	String phone1=request.getParameter("phone1");
	String phone2=request.getParameter("phone2");
	String phone3=request.getParameter("phone3");
	String email1=request.getParameter("email1");
	String email2=request.getParameter("email2");
	
	MemberDTO dto= new MemberDTO(userid, passwd, username, post, addr1, addr2, phone1, phone2, phone3, email1, email2);
	System.out.println("파싱데이터==="+dto);
	//SERVICE에  dto  전송  db 에 insert(SERVICE->DAO이용->MAPPER 이용)
	MemberService service= new MemberService();
	service.memberAdd(dto);
	//이후  SESSION에 회원가입 정보 저장(다음 줄 코드임) 
	HttpSession session=request.getSession();
	session.setAttribute("mesg", "회원가입성공");
		
	//메인화면으로 이동//추후 설명 
	response.sendRedirect("MainServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
