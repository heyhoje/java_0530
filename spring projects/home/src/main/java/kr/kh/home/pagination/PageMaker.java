package kr.kh.home.pagination;

import lombok.Data;

@Data
// 현재 페이지 정보에 관한 페이지네이션
public class PageMaker {

	private int startPage; // 현재 페이지네이션에서 시작 페이지 번호
	private int endPage; // 현재 페이지네이션에서 마지막 페이지 번호
	private boolean prev; // 이전 버튼 활성화 여부
	private boolean next; // 다음 버튼 활성화 여부
	private int displayPageNum; // 한 페이지네이션에서 최대 페이지 개수
	private Criteria cri; // 현재 페이지네이션에서 현재 페이지번호
	private int totalCount; // 마지막 페이지네이션에서 마지막 페이지 번호를 위한 전체 컨텐츠 개수
	
	/** 여러가지 계산해주는 코드. 그냥 기억하시면 됩니다... */
	public void calculate() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		
		/**모르겠으면 외우지도 말고 필요한 부분에 복붙할 수 있으면 됨*/
		// 마지막 페이지네이션에서 마지막 페이지 번호, 내가 지정한 단위로 끊어지지가 않음
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		// 현재 페이지가 마지막 페이지네이션이면
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		// 첫번째 페이지네이션이면 이전 버튼 비활성화
		prev = startPage == 1? false : true;
		
		// 마지막 페이지네이션이면 다음 버튼 비활성화 (
		next = endPage == tmpEndPage ? false : true;
	}

	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
	
	
}
