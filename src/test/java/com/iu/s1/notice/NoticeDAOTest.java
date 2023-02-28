package com.iu.s1.notice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyTestCase {
	
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title");
		noticeDTO.setWriter("Writer");
		noticeDTO.setContents("Contents");
	}

}
