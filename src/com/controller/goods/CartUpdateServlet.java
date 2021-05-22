package com.controller.goods;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num"); //주문번호
		String gAmount=request.getParameter("gAmount"); //수량
		
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		String nextPage=null;
		if(dto!=null) { //로그인이 되어있는경우 , 회원인증이 된경우
			HashMap<String, Integer> map=new HashMap<String, Integer>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));
			
			CartService service = new CartService();
			int n=service.cartUpdate(map);
			System.out.println("cart 업데이트==="+n);
			
		}else {
			nextPage="LoginUIServlet";
			session.setAttribute("mesg", "로그인이필요한 작업");
			response.sendRedirect(nextPage);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
