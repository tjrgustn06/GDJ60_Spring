package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value ="list")
	public String getProductList() throws Exception {
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size()>0);
		return "product/productList";
	}
	
	
	@RequestMapping(value ="detail")
	public String ProductDetail() {
		System.out.println("Product Detail");
		
		return "product/productDetail";
	}
	
	//productAdd jsp명과 URL주소가 일치하면 리턴타입은 보이드로 써도 된다.
	@RequestMapping(value="productAdd")
	public void getProductAdd() {		
		System.out.println("Product Add");
	}
	
	@RequestMapping(value = "update")
	public ModelAndView update() {
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/prodctUpdate");
		return mv;
		
	}
	
}
