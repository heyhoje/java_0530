package kr.kh.edu.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지
	private int perPageNum; //한 페이지에서 컨텐츠 개수
	
	// 멤버변수 추가
	private String t; // type
	private String s; // search
	
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
		
		// 기본값 설정
		t = "all";
		s = "";
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
		// 셍성자에도 추가
		t = "all";
		s = "";
	}
	
	//게시글 리스트에서 현재 페이지에 맞는 게시글을 가져오기 위한 시작 번지 
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	
	/** 메소드 오버로딩으로 작업.... 저번에는 currentPage인가 넣었다고 함 */
	public String getUrl(int page) {
		return "?t=" + t + "&s=" + s + "&page=" + page;
	}
	
	public String getUrl() {
		return "?t=" + t + "&s=" + s + "&page=" + page;
	}
}