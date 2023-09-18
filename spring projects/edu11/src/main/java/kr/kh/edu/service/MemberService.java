package kr.kh.edu.service;

import kr.kh.edu.vo.MemberVO;

public interface MemberService {

	// 회원가입
	boolean signup(MemberVO member);

	boolean checkId(String id);

	//로그인
	MemberVO login(MemberVO member);

}
