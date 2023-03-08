package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBookComment/**")
public class BankBookCommentController {

	@Autowired
	private BbsService bankBookCommentService;
	
	@GetMapping("list")
	public ModelAndView getBoardList(ModelAndView mv, Pager pager)throws Exception{
		
		List<BbsDTO> ar = bankBookCommentService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("common/commentList");		
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO, HttpSession session, ModelAndView mv) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//bankBookCommentDTO.setWriter(memberDTO.getId());
		bankBookCommentDTO.setWriter(memberDTO.getId());
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO, null, null);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO, ModelAndView mv) throws Exception {
		
		int result = bankBookCommentService.setBoardDelete(bankBookCommentDTO, null);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO, ModelAndView mv)throws Exception{
		
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}
