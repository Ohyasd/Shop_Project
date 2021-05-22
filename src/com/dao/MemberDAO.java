package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class MemberDAO {

   public int memberAdd(SqlSession session,MemberDTO dto) {
	int n=session.insert("MemberMapper.memberAdd",dto);
	  return n;
   }

public int idCheck(SqlSession session, String userid) {
	int count=session.selectOne("MemberMapper.idCheck",userid);
	return count;
}

public MemberDTO login(SqlSession session, Map<String, String> map) {
	MemberDTO dto=session.selectOne("MemberMapper.login",map);
	return dto;
	
}


public MemberDTO mypage(SqlSession session, String userid) {
	MemberDTO dto=session.selectOne("MemberMapper.mypage",userid);
	return dto;
}

public int memberUpdate(SqlSession session, MemberDTO dto2) {
	int n=session.update("MemberMapper.memberUpdate",dto2);
	return n;
}

public String idSearch(SqlSession session, MemberDTO dto) {
	String n=session.selectOne("MemberMapper.idSearch",dto);
	return n;
}




}
