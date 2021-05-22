package com.controller.goods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartDelAllServlet
 */
@WebServlet("/CartDelAllServlet")
public class CartDelAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) { //로그인되어있는경우 , 회원인경우
	    String data=request.getParameter("data");
	    System.out.println(data);
	    
		 String[] x=data.split(","); // ex)11,12,13 이라면 쉼표부분을 잘라내주고 list생성
		 List<String>list=Arrays.asList(x); 
		 
		 CartService service=new CartService();
		 int n=service.cartAllDel(list);
		System.out.println("삭제된 cart"+n);
		 nextPage="CartListServlet";
	
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		response.sendRedirect(nextPage);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
