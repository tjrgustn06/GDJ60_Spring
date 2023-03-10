package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("memberIdCheck")
	public ModelAndView getMemberInCheck(MemberDTO memberDTO) throws Exception {
		
		boolean check = memberService.getMemberIdCheck(memberDTO);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		
		return mv;
		
	}
	
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
	public ModelAndView memberLogin(ModelAndView mv, HttpServletRequest request) throws Exception {
		
		mv.setViewName("member/memberLogin");
		
//		Cookie [] cookies = request.getCookies();
//		
//		for(Cookie cookie: cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("-----------------------------");
//			if(cookie.getName().equals("rememberId")) {
//				mv.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		
		return mv;
	}
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(ModelAndView mv, MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception {
		
	if(remember!=null && remember.equals("remember")) {
		Cookie cookie = new Cookie("rememberId", memberDTO.getId());
		cookie.setMaxAge(-1); //초단위   -1은 영구히 저장
		response.addCookie(cookie);				
	}else {
		Cookie cookie = new Cookie("rememberId", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
	}
		
//		memberDTO = memberService.getMemberLogin(memberDTO);
//		
//		if(memberDTO !=null) {
//		HttpSession session = request.getSession();
//		session.setAttribute("member", memberDTO);
//		}
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
