package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartDAO {

	public int cartAdd(SqlSession session, CartDTO dto2) {
		int n=session.insert("CartMapper.cartAdd",dto2);
		return n;
	}

	public List<CartDTO> cartList(SqlSession session, String userid) {
		List<CartDTO> list=session.selectList("CartMapper.cartList",userid);
		return list;
	}


	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n=session.delete("CartMapper.cartUpdate",map);
		return n;
	}

	public int cartAllDel(SqlSession session, List<String> list) {
		int n=session.delete("CartMapper.cartAllDel",list);
		return n;
	}

	public CartDTO cartbyNum(SqlSession session, String num) {
		CartDTO dto=session.selectOne("CartMapper.cartbyNum",num);
		return dto;
	}
	public int orderDone(SqlSession session, OrderDTO odto) {
		int n=session.insert("CartMapper.orderDone",odto);
		return n;
		
	}
	public int cartDel(SqlSession session, int orderNum) {
		int n=session.delete("CartMapper.cartDel",orderNum);
		return n;
	}

	public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list) {
		List<CartDTO> list2=session.selectList("CartMapper.orderAllConfirm",list);
		return list2;
	}

	public int orderAllDone(SqlSession session, List<OrderDTO> x) {
		int n=session.insert("CartMapper.orderAllDone",x);
		return n;
	}

}
