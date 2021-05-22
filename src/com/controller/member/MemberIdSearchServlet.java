package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MemberIdSearchUIServlet
 */
@WebServlet("/MemberIdSearchServlet")
public class MemberIdSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username=request.getParameter("username");
		String phone1=request.getParameter("phone1");
		String phone2=request.getParameter("phone2");
		String phone3=request.getParameter("phone3");
		String email1=request.getParameter("email1");
		String email2=request.getParameter("email2");
		
		MemberService service= new MemberService();
		MemberDTO dto= new MemberDTO();
		dto.setUsername(username);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);

		
		String userid=service.idSearch(dto);//아이디찾기에서 보내준 정보의 유저데이터중 userid만 뽑음
		//System.out.println(userid); //아이디찾기에서 보내준 정보의 유저데이터중 userid만 뽑아서 출력
		String nextPage=null;
		if(userid==null) { //일치하는 정보가 없을때
			nextPage="MemberIdSearchUIServlet";
			request.setAttribute("mesg", "이름 또는 핸드폰이 등록되지않은 정보");
			
		}else { //일치하는 정보가 있을때
			nextPage="SendMailServlet"; //메일을 보내줄것임
			request.setAttribute("mailTo",email1+"@"+email2);
			request.setAttribute("userid", userid);
		}
		RequestDispatcher dis= request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
