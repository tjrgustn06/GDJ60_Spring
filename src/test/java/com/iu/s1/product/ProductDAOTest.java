package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getProductListTest() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		//단정문 (TEST 케이스에만 있음)
		assertNotEquals(0, ar.size());
		
	}
	@Test
	public void getProductDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(1L);
		productDTO = productDAO.getProductdetail(productDTO);
		assertNotNull(productDTO);
	}
	
	@Test
	public void setProductAddTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(21L);
		productDTO.setProductName("Test");
		productDTO.setProductDetail("qwewq");
		int result = productDAO.setProductAdd(productDTO);
		assertEquals(1, result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
