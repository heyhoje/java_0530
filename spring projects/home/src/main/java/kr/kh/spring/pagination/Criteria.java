package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지
	private int perPageNum; //한 페이지에서 컨텐츠 개수
	
	// 검색창 관련된것을 BoardService 에서 매개변수로 다 넘겨주면 귀찮으니까 
	private String type; // 검색 타입
	private String search; // 검색어
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
		type="0"; // 전체 검색
		search=""; // 기본 검색어 
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	//게시글 리스트에서 현재 페이지에 맞는 게시글을 가져오기 위한 시작 번지 
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
	public String getUrl(int page) {
		return "?page=" + page + "&type=" + type + "&search=" + search;
	}
	public String getCurrentUrl() {
		return "?page=" + page + "&type=" + type + "&search=" + search;
	}
}