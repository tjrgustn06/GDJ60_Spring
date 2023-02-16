package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
public class ProductService {

	//결합도가 높다(강하다)
	
	@Autowired
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductdetail(productDTO);
	}
	
	public List<ProductDTO> getProductList(Pager pager) throws Exception{
		
		Long totalCount = productDAO.getProductCount(pager);
		pager.makeNum(totalCount);		
		pager.makeRow();
		
		return productDAO.getProductList(pager);
		
	}
	
	
	public int setProductAdd (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//prdoct , option 등록
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar !=null) {
		
		for(ProductOptionDTO productOptionDTO:ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);		
		}
	}
		
		return result;
	}


}
