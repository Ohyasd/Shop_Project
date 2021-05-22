package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.MemberDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartService {

	public int cartAdd(CartDTO dto2) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.cartAdd(session, dto2);
			session.commit();
		}finally {
			session.close();
		}
		return n;
		
		
	}

	

	public List<CartDTO> cartList(String userid) {
		SqlSession session=MySqlSessionFactory.getSession();
		List<CartDTO> list=null;
		try {
			CartDAO dao= new CartDAO();
			list=dao.cartList(session, userid);
		}finally {
			session.close();
		}
		return list;
	}



	public int cartDel(int num) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.cartDel(session, num);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}



	public int cartUpdate(HashMap<String, Integer> map) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.cartUpdate(session, map);
			session.commit();
		}finally {
			session.close();
		}
		return n;
		
	}



	public int cartAllDel(List<String> list) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.cartAllDel(session, list);
			session.commit();
		}finally {
			session.close();
		}
		return n;
		
	}



	public CartDTO cartbyNum(String num) {
		SqlSession session=MySqlSessionFactory.getSession();
		CartDTO cdto=null;
		try {
			CartDAO dao= new CartDAO();
			cdto=dao.cartbyNum(session, num);
			session.commit();
		}finally {
			session.close();
		}
		return cdto;
		
	}
	
	public int orderDone(OrderDTO odto,String orderNum) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.orderDone(session, odto);
			n=dao.cartDel(session,Integer.parseInt(orderNum));
			session.commit();
		}catch (Exception e) {
			session.rollback();
			System.out.println("rollback===="+e);
		}finally {
			session.close();
		}
		return n;
		
	}



	public List<CartDTO> orderAllConfirm(List<String> list) {
		SqlSession session=MySqlSessionFactory.getSession();
		List<CartDTO> list2=null;
		try {
			CartDAO dao= new CartDAO();
			list2=dao.orderAllConfirm(session, list);
			
		}finally {
			session.close();
		}
		return list2;
	}



	public int orderAllDone(List<OrderDTO> x, List<String> nums) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			CartDAO dao= new CartDAO();
			n=dao.orderAllDone(session, x);
			n=dao.cartAllDel(session, nums);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}


}
