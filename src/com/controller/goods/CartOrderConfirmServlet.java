package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class CartOrderConfirmServlet
 */
@WebServlet("/CartOrderConfirmServlet")
public class CartOrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
   HttpSession session=request.getSession();
	MemberDTO dto=(MemberDTO)session.getAttribute("login");
	String nextPage=null;
	if(dto!=null) { //로그인되어있는경우 , 회원인경우
		 String num=request.getParameter("num"); //주문번호 가져오기
		 String userid=dto.getUserid();//사용자 id꺼내기
		 
		 MemberService service=new MemberService();
		 MemberDTO mdto=service.mypage(userid); //사용자id에 맞는 회원정보 뽑아오기
		 
		 request.setAttribute("mdto", mdto); //mdto키값으로 저장
		 
		 CartService service2=new CartService();
		 CartDTO cdto=service2.cartbyNum(num);//해당 주문번호에 해당하는 주문리스트 뽑아오기
		 
		 request.setAttribute("cdto", cdto); //cdto키값으로 저장
		 nextPage="orderConfirm.jsp";
		 
	}else {
		nextPage="LoginUIServlet";
		session.setAttribute("mesg","로그인이 필요한 작업입니다.");
		
	}
	RequestDispatcher dis=request.getRequestDispatcher(nextPage);
	dis.forward(request, response);
	
   
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
