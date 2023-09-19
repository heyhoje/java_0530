package kr.kh.edu.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	int bo_num; 
	String bo_title; 
	String bo_contents; 
	int bo_views; 
	
	Date bo_reg_date;
	Date bo_up_date; 
	int bo_ori_num; 
	String bo_me_id; 
	
	int bo_up; 
	int bo_down; 
	
	int bo_comment; 
	int bo_bt_num;
}
