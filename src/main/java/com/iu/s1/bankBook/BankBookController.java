package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//List
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankbookList(ModelAndView mv) throws Exception {
		
		List<BankBookDTO> ar = bankBookService.getBankBookList();
		
		mv.setViewName("bankBook/list");
		mv.addObject("list", ar);
		return mv;
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankBookDetail(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.setViewName("bankBook/detail");
		mv.addObject("detail", bankBookDTO);
		return mv;
	}
	
	//Add(insert)
	@RequestMapping(value ="add", method = RequestMethod.GET )
	public ModelAndView setBankBookAdd(ModelAndView mv) throws Exception {
	
		mv.setViewName("bankBook/add");
		mv.addObject("Add", mv);
		return mv;
	}
	
	@RequestMapping(value ="add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(ModelAndView mv, BankBookDTO bankBookDTO)throws Exception {
		
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET  )
	public ModelAndView setBankBookDelete(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(ModelAndView mv, BankBookDTO bankBookDTO) throws Exception {
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		
		mv.setViewName("bankBook/update");
		mv.addObject("dto", bankBookDTO);
		
		return mv;

	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	
	
}
