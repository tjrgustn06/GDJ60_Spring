package com.iu.s1.bankBook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.product.ProductDTO;


public class BabkBookDAOTest extends MyTestCase {
	
	@Autowired
	BankBookDAO bankBookDAO;
	
//	@Test
//	public void getBankBookList() throws Exception {
//		
//		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
//		
//		assertEquals(0, ar.size());
//	}
	
	@Test
	public void setBankBookAddTest() throws Exception {
		for(int i=0; i<30; i++) {
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d*1000);
			d = num/100.0;
		
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		bankBookDTO.setBookName("하나적금"+i);
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		}
		System.out.println("끝");
	}
	
	
}
