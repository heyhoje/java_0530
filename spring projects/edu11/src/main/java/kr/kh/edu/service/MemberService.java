package kr.kh.edu.service;

import kr.kh.edu.vo.MemberVO;

public interface MemberService {

	MemberVO getMember(String id);
	
	boolean signup(MemberVO member);

}