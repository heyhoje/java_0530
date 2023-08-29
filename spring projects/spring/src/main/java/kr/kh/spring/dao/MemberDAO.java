package kr.kh.spring.dao;

import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	int selectMember();

}
