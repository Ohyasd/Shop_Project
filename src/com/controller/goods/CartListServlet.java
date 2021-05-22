package com.controller.goods;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	MemberDTO dto=(MemberDTO)session.getAttribute("login");
	String nextPage=null;
	if(dto!=null) { //로그인되어있는경우 , 회원인경우
		String userid=dto.getUserid();
		CartService service= new CartService();
		List<CartDTO> list=service.cartList(userid); //userid가 담은 장바구니리스트
		
		request.setAttribute("cartList", list);
		nextPage="cartList.jsp";
		
	}else { //아닌경우
		nextPage="LoginUIServlet";
		session.setAttribute("mesg", "로그인이필요한 작업");
		
	}
	RequestDispatcher dis=request.getRequestDispatcher(nextPage);
	dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
