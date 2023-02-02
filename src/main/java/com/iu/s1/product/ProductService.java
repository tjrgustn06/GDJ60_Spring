package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	//결합도가 높다(강하다)
	
	@Autowired
	private ProductDAO productDAO = new ProductDAO(); 
	
	
	
	
	public int setAddProduct (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//prdoct , option 등록
		int productNum = productDAO.getProductNum();
		productDTO.setProductnum(productNum);
		int result = productDAO.SetAddProduct(productDTO);
		
		for(ProductOptionDTO productOptionDTO:ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);		
		}
		
		return result;
	}




	public List<ProductDTO> getProductList() {
		
		
		return null;
	}
	

}
