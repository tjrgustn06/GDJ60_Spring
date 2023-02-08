package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value ="list")  	//DS에서 mv를 받아옴
	public ModelAndView getProductList(ModelAndView mv) throws Exception {
		
		//ModelAndView mv = new ModelAndView();  ==>직접 만드는거
		
		List<ProductDTO> ar = productService.getProductList();
		
		System.out.println(ar.size()>0);
		
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		
		return mv;
	}
	
	
	@RequestMapping(value ="detail")	//Integer num->파라미터 이름과 동일하게 적어야 됨
	public String ProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//파라미터 이름과 setter(set을 제외한 클래스명의 첫글자가 소문자)의 이름과 같아야 함
			
		System.out.println("Product Detail");
		//String num = request.getParameter("num");
		
		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductnum(num);		//파라미터 이름과 동일하게 적어야 됨	
		productDTO = productService.getProductDetail(productDTO);
		
		
		
		System.out.println(productDTO !=null);

		model.addAttribute("dto", productDTO);
		
		return "product/productDetail";
	}
	
	//productAdd jsp명과 URL주소가 일치하면 리턴타입은 보이드로 써도 된다.
	@RequestMapping(value="productAdd", method = RequestMethod.GET)
	public void setProductAdd() {		
			
	}
	
	
	@RequestMapping(value = "productAdd", method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception {
		int result = productService.setProductAdd(productDTO, null);
		System.out.println(result == 1);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "update")
	public ModelAndView update() {
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/prodctUpdate");
		return mv;
		
	}
	
}
