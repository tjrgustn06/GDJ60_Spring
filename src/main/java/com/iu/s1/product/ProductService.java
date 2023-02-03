package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	//결합도가 높다(강하다)
	
	@Autowired
	private ProductDAO productDAO = new ProductDAO(); 
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductdetail(productDTO);
	}
	
	public List<ProductDTO> getProductList() throws Exception{
		return productDAO.getProductList();
	}
	
	
	public int setAddProduct (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//prdoct , option 등록
		int productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.SetAddProduct(productDTO);
		
		if(ar !=null) {
		
		for(ProductOptionDTO productOptionDTO:ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);		
		}
		}
		
		return result;
	}



}
