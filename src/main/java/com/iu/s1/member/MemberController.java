package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.bankBook.BankBookService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//add
	@RequestMapping(value="memberJoin", method= RequestMethod.POST)
	public ModelAndView memberJoin(ModelAndView mv, MemberDTO memberDTO) throws Exception {
		
		int result = memberService.setMemberJoin(memberDTO);
		mv.setViewName("redirect:../");
		
		return mv;
		
	}
	
	@RequestMapping(value="memberJoin", method= RequestMethod.GET)
	public ModelAndView memberJoin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberJoin");
		mv.addObject("join", mv);
		
		return mv;
	}
	
	
	@RequestMapping(value="memberLogin", method = RequestMethod.GET)
	public ModelAndView memberLogin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		
		memberDTO = memberService.getMemberLogin(memberDTO);
		
		if(memberDTO !=null) {
		HttpSession session = request.getSession();
		session.setAttribute("member", memberDTO);
		}
		mv.setViewName("redirect:../");
		
		return mv;
	}
	@RequestMapping(value="memberlogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@RequestMapping(value="memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		
	 	memberDTO = memberService.getMemberPage(memberDTO);
	 	mv.addObject("dto", memberDTO);
		
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.GET)
	public ModelAndView getMemberUpdate(HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		mv.setViewName("member/memberUpdate");
		mv.addObject("dto",mv);
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.POST)
	public ModelAndView getMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();	
		MemberDTO sessionMemberDTO =(MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMemberDTO.getId());
		int result = memberService.setMemberUpdate(memberDTO);
//		if(result>0) {
//			session.setAttribute("member", memberDTO);
//		}
		
		mv.setViewName("redirect:./memberPage");
		return mv;
	}

	
}
