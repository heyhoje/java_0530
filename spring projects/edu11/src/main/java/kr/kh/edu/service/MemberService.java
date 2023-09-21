package kr.kh.edu.service;

import kr.kh.edu.vo.MemberVO;

public interface MemberService {

	// 회원가입
	boolean signup(MemberVO member);
	
	// 아이디 중복확인
	boolean checkId(String id);

	//로그인
	MemberVO login(MemberVO member);
	
	// 자동로그인
	void updateMemberSeesion(MemberVO user);

}
