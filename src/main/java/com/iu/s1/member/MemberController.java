package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.bankBook.BankBookService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//add
	@RequestMapping(value="memberjoin", method= RequestMethod.POST)
	public ModelAndView memberJoin(ModelAndView mv, MemberDTO memberDTO) throws Exception {
		
		int result = memberService.setMemberJoin(memberDTO);
		mv.setViewName("redirect:../");
		
		return mv;
		
	}
	
	@RequestMapping(value="memberjoin", method= RequestMethod.GET)
	public ModelAndView memberJoin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberJoin");
		mv.addObject("join", mv);
		
		return mv;
	}
	
	
	@RequestMapping(value="memberlogin", method = RequestMethod.GET)
	public ModelAndView memberLogin(ModelAndView mv) throws Exception {
		
		mv.setViewName("member/memberLogin");
		mv.addObject("login", mv);
		
		return mv;
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		
		memberDTO = memberService.getMemberLogin(memberDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", session);
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	@RequestMapping(value="memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:../");
		session.invalidate();
		
		return mv;
	}
	
	@RequestMapping(value="memberpage", method = RequestMethod.GET)
	public ModelAndView getMemberPage()throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.GET)
	public ModelAndView getMemberUpdate() throws Exception {
		
		ModelAndView mv = new ModelAndView();
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
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		
		mv.setViewName("redirect:./memberpage");
		return mv;
	}
	
	
}
