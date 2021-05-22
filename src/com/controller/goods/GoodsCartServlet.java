package com.controller.goods;

import java.io.IOException;

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
 * Servlet implementation class GoodsCartServlet
 */
@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session=request.getSession();
	MemberDTO dto=(MemberDTO)session.getAttribute("login");
	String nextPage=null;
	if(dto!=null) { //로그인이 되어있는경우 , 회원인증이 된경우
	String gImage=request.getParameter("gImage");
	String gCode=request.getParameter("gCode");
	String gName=request.getParameter("gName");
	String gPrice=request.getParameter("gPrice");
	String gSize=request.getParameter("gSize");
	String gColor=request.getParameter("gColor");
	String gAmount=request.getParameter("gAmount");
	String userid=dto.getUserid(); //세션에 저장된 데이터사용
	
	CartDTO cdto= new CartDTO();
	cdto.setgCode(gCode);
	cdto.setgSize(gSize);
	cdto.setgName(gName);
	cdto.setgPrice(Integer.parseInt(gPrice));
	cdto.setgColor(gColor);
	cdto.setgAmount(Integer.parseInt(gAmount));
	cdto.setgImage(gImage);
	cdto.setUserid(userid);
	
	CartService service= new CartService();
	int n=service.cartAdd(cdto);
	System.out.println("insert된 장바구니:"+n);
	
	nextPage="GoodsRetrieveServlet?gCode="+gCode;
	session.setAttribute("mesg", gCode+" Cart저장 되었습니다.");
	}else {
		nextPage="LoginUIServlet";
		session.setAttribute("mesg","로그인이 필요한 작업입니다.");
	}
	
	response.sendRedirect(nextPage); //리다이렉트시에 url?key=value 데이터 전송이가능
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
