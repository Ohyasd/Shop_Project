package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String userid=request.getParameter("userid");
	
	MemberService service= new MemberService();
	int count=service.idCheck(userid);
	System.out.println("MemberIdCheckServlet count:"+count);
	String mesg="아이디 사용가능";
	if(count==1) {
		mesg="아이디 중복";
	}
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out= response.getWriter();
	out.print(mesg); //html 설정없이 mesg값만 out
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
