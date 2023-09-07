package kr.kh.spring.vo;

import lombok.Data;

@Data
public class CommentVO {
	private int co_num;
	private String co_contents;
	private int co_bo_num;
	private String co_me_id; 
}
