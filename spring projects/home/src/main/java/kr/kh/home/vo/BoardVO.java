package kr.kh.home.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bo_num, bo_ori_num, bo_views, bo_up, bo_down, bo_bt_num, bo_comment;
	private String bo_title, bo_me_id, bo_contents;
	private Date bo_reg_date, bo_up_date; // util 로 임포트 / 오예 내꺼 힌트 찾았당
}
