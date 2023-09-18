package kr.kh.edu.vo;

import lombok.Data;

@Data
public class MemberVO {

	String me_id;
	String me_pw;
	String me_role;
	String me_email;
	
	// 자동 로그인 관련 속성
	String me_session_id;
	String me_session_limit;
}
