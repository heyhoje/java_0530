package kr.kh.home.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.home.vo.MemberVO;

public interface MemberDAO {

	MemberVO selecetMember(@Param("me_id")String me_id);

	boolean insertMember(@Param("m")MemberVO member);


}
