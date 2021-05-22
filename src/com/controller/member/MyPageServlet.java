package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		//System.out.println(dto); //로그인정보가 있는지 가져옴
		String nextPage=null;
		MemberService service= new MemberService();
		if(dto!=null) {
			nextPage="mypage.jsp";
			String userid=dto.getUserid();
		MemberDTO x=service.mypage(userid);//id를 꺼내 db에서 id에 맞는 데이터정보가져오기
		//System.out.println("dto2====="+x);
		session.setAttribute("login", x); //가져온 정보를 다시 세션에 login 이라는 키로 저장
		
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다");
		}
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
