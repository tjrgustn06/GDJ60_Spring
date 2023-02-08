package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;


public class BabkBookDAOTest extends MyTestCase {
	
	@Autowired
	BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookList() throws Exception {
		
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		
		assertEquals(0, ar.size());
	}
}
