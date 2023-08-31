package kr.kh.home.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page; // 현재 페이지
	private int perPageNum; // 한 페이지에서 컨텐츠 개수
	
	public Criteria() { // 기본생성자는 꼭 필요함. 컨트롤러에서 매개변수로 받을때, 호출받는애가 기본생성자!!
		page = 1;
		perPageNum = 10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	/** 게시글 리스트에서 현재 페이지에 맞는 게시글을 가져오기 위한 시작번지*/
	public int getPageStart() {
		return (page -1) * perPageNum;
	}
}
