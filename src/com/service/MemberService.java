package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {

	public int memberAdd(MemberDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao= new MemberDAO();
			n=dao.memberAdd(session, dto);
			session.commit();
		}finally {
			session.close();
		}
		return n;
		
	}

	public int idCheck(String userid) {
		SqlSession session=MySqlSessionFactory.getSession();
		int count=0;
		try {
			MemberDAO dao= new MemberDAO();
			count=dao.idCheck(session, userid);
			
		}finally {
			session.close();
		}
		return count;
		
	}

	public MemberDTO login(Map<String, String> map) {
		SqlSession session=MySqlSessionFactory.getSession();
		MemberDTO dto=null;
		try {
			MemberDAO dao= new MemberDAO();
			dto=dao.login(session, map);
			
		}finally {
			session.close();
		}
		return dto;
		
		
		
	}

	public MemberDTO mypage(String userid) {
		SqlSession session=MySqlSessionFactory.getSession();
		MemberDTO dto=null;
		try {
			MemberDAO dao= new MemberDAO();
			dto=dao.mypage(session, userid);
			
		}finally {
			session.close();
		}
		return dto;
		
	}

	public int memberUpdate(MemberDTO dto2) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao= new MemberDAO();
			n=dao.memberUpdate(session, dto2);
			session.commit();
			
		}finally {
			session.close();
		}
		return n;
	}

	public String idSearch(MemberDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		String n=null;
		try {
			MemberDAO dao= new MemberDAO();
			n=dao.idSearch(session, dto);
			session.commit();
			
		}finally {
			session.close();
		}
		return n;
	}

}
