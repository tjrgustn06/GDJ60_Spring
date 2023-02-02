package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.s1.util.DBConnection;

public class MemberDAO {

	
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER(ID, PW, NAME, PHONE, ADDRESS, EMAIL "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getAddress());
		st.setString(6, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
		
	}
	
	public static void main(String[] args) {
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = new MemberDTO();
	
	
	}
	
}
