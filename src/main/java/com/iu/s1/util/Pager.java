package com.iu.s1.util;

public class Pager {
	
	private Long bookNumber;
	
	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}
	//검색종류 (사용할 컬럼)kind
	private String kind;
	
	//검색어
	private String search;
	
	//한페이지에 출력할 ROW의 갯수	
	private Long perPage;
	
	//한 블럭당 출력할 번호의 갯수
	private Long perBlaock;
	
	//전체 페이지 갯수(totalpage)
	private Long totalPage;
	
	public Long getTotalPage() {
		return totalPage;
	}
	//Client가 보고싶은 페이지 번호(parameter)
	private Long page;
	
	//Table에서 조회할 시작번호
	private Long startRow;
	//Table에서 조회할 끝번호
	private Long lastRow;
	
	//전체 row의 갯수를 담을 변수
	private Long totalCount;
	
	private Long startNum;
	private Long lastNum;
	
	private boolean before;
	private boolean after;
		
	
	//StartNum,lastNum
	public void makeNum(Long totalCount) {
		
		//1.전체 row의 갯수 구하기
		//2.총 page의 갯수 구하기
		this.totalPage = totalCount/this.getPerPage();
		
		if(totalCount % this.getPerPage() !=0) {			
			this.totalPage++;
		}
			if(this.getPage()>this.totalPage) {
				this.setPage(this.totalPage);
			}
		
		//3.한 블럭에 출력할 번호의 갯수
		
				
		//4.총 블럭의 수 구하기
		Long totalBlock = this.totalPage/this.getPerBlaock();
		if(this.totalPage % this.getPerBlaock() !=0) {
			totalBlock++;
		}
		//5 page 번호로 현재 블럭 번호 구하기
		// page 1~5 curBlock=1
		// page 6~10 curBlock=2
		
		Long curBlock = this.page / this.getPerBlaock();
		if(this.getPage() % this.getPerBlaock() !=0) {
			curBlock++;
		}
		//6. curBlock의 시작번화 끝번호를 계산
		this.startNum=(curBlock-1)*this.getPerBlaock()+1;
		this.lastNum= curBlock*this.getPerBlaock();
		
		this.after = true;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			this.after=false;
		}
		
		if(curBlock ==1) {
			this.before = true;
		}
		
	}
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		
		if(search == null) {
			search="";
		}
		return 	search;		//"%"+search+"%";
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	

	public Long getPerBlaock() {
		if(this.perBlaock ==null || this.perBlaock < 1) {
			this.perBlaock =5L;
		}
		
		return perBlaock;
	}

	public void setPerBlaock(Long perBlaock) {
		this.perBlaock = perBlaock;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Pager() {
		this.perPage=10L;
	}
	
	//startRow lastRow 계산 하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public Long getPerPage() {
		if(this.perPage ==null || this.perPage==0) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPage() {
		if(this.page == null ||this.page < 1 ) {
			this.page = 1L;
		}
		return page;
		
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
}
