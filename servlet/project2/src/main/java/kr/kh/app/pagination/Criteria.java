package kr.kh.app.pagination;

import lombok.Data;

//현재 페이지 정보를 나타내는 클래스
//현재 몇 페이지인지, 어떤 검색어인지, 게시글 정렬 방법은 무엇인지 등

@Data
public class Criteria {
	
	// 현재 페이지
	private int page;
	// 한 페이지에 게시글 수
	private int perPageNum;
	// 검색어, 정렬방법 ㅡ 스프링에서
	
	// 한 페이지에 게시글이 5개가 있고, 현재 페이지가 3페이지이면
	// limit을 이용할 때 limit 10번지부터 5개를 가져오라고 입력해야하는데, 
	// limit에서 시작 번지를 계산하는 getter
	public int getPageStart() {
		return (page - 1 ) * perPageNum;
	}
}
