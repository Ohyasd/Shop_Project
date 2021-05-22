package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String userid=request.getParameter("userid");
	String passwd=request.getParameter("passwd");
	
	Map<String,String> map= new HashMap<String, String>();
	map.put("userid", userid);
	map.put("passwd", passwd);
	
	MemberService service =new MemberService();
	MemberDTO dto=service.login(map);
	//System.out.println(dto);
	
	//String nextPage=null;
	if(dto!=null) { //회원인경우
		//nextPage="main.jsp";
		HttpSession session=request.getSession();
		session.setAttribute("login", dto);
		response.sendRedirect("MainServlet");
	}else{
		response.sendRedirect("LoginUIServlet");
		//nextPage="LoginUIServlet";
	}
	//response.sendRedirect(nextPage);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
