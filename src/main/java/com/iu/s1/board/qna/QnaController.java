package com.iu.s1.board.qna;

import java.net.http.HttpHeaders;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		
		return "qna";
	}
	

	
	@RequestMapping(value ="list", method = RequestMethod.GET)
	public ModelAndView getQnaList(ModelAndView mv, Pager pager) throws Exception {
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		//Header
				HttpHeaders headers = new HttpHeaders();
				//1. headers.add("header명", "header값");
				headers.add("Content-Type","application/x-www-form-urlencoded");
				//2. headers.set헤더명("header값");
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
				
				//parameter(post)
				MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
				params.add("파라미터명", "파라미터값");
				params.add("grant_type", "authorization_code");
				params.add("client_id", "${REST_API_KEY}");
				
				//header, params 하나의 객체로 생성
				HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params, headers); 
				
				
				//String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class, request);
				String result = restTemplate.postForObject("https://dummyjson.com/products/1", request, String.class);
				
				System.out.println(result);
		
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd(ModelAndView mv) throws Exception {
		mv.setViewName("board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(ModelAndView mv ,QnaDTO qnaDTO, MultipartFile [] addFiles, HttpSession session) throws Exception {
		
		int result = qnaService.setBoardAdd(qnaDTO, addFiles, session);
		
		String message="등록 실패";
		
		if(result>0) {
			message="글이 등록 되었습니다";
		}
		
		mv.addObject("result", result);
		mv.addObject("url", "./list");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView setBoardDetail(ModelAndView mv, QnaDTO qnaDTO) throws Exception {
		
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String message="등록 실패";
		
		if(result>0) {
			message="글이 등록 되었습니다";
		}
		
		mv.setViewName("common/result");
		mv.addObject("result", message);
		mv.addObject("url", "./detail?num="+qnaDTO.getNum());
		
		return mv;
	}
	
	@PostMapping("dlelte")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("common/result");
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		String message="삭제 실패";
		
		if(result>0) {
			message="삭제 성공";
		}
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
		
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		mv.addObject("dto", boardDTO);
		
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile[] addFiles, HttpSession session, Long [] fileNums) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNums);
		
		mv.setViewName("common/result");
		mv.addObject("result", "수정 성공");
		mv.addObject("url", "./list");
		
		return mv;
	}
	//--------------------------------------------------------------------------
	

	
	
	
}
