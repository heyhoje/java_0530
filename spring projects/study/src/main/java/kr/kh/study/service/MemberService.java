package kr.kh.study.service;

import kr.kh.study.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	void updateMemberSession(MemberVO user);

	MemberVO getMemberBySession(String me_session_id);

	
}