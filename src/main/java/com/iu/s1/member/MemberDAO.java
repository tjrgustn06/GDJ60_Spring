package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

//@Repository
//public class MemberDAO {
//	
//	@Autowired
//	private SqlSession sqlSession;
//	private final String NAMESPACE = "com.iu.s1.member.MemberDAO.";
//	
//	
//	public int setMemberJoin(MemberDTO memberDTO) throws Exception{
//
//		return SqlSession.insert(NAMESPACE +"setMemberJoin", memberDTO);
//		
//	}
//	
//}