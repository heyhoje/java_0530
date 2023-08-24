package db.day3.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int bo_num;
	private String bo_title;
	private String bo_me_id;
	
	// »ý¼ºÀÚ
	public BoardVO(String title, String me_id) {
		this.bo_title = bo_title;
		this.bo_me_id = bo_me_id;
	}

	public BoardVO(int num, String title, String me_id) {
		this.bo_num = num;
		this.bo_title = title;
		this.bo_me_id = me_id;
	}

	public BoardVO(String title, String id) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[" + bo_num + "]" + bo_title + " : [" + bo_me_id + "]";
	}

	
