package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;

@Service
public class BankBookCommentService implements BbsService {

	@Autowired
	private BbsDAO bankBookCommentDAO;
	
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(bankBookCommentDAO.getTotalCount(pager));
		
		return bankBookCommentDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
			int result = bankBookCommentDAO.setBoardAdd(bbsDTO);
				
			return result;
		}


	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		
		return bankBookCommentDAO.setBoardUpdate(bbsDTO);
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		
		
		return  bankBookCommentDAO.setBoardDelete(bbsDTO);
	}
	

	
}