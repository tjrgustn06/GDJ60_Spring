package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;

import com.iu.s1.util.DBConnection;

public class MemberDAO {

	
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{

		
		return SqlSession.insert(NAMESPACE+ , memberDTO);
		
	}
	
	public static void main(String[] args) {
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = new MemberDTO();
	
	}
	
	
	
}
