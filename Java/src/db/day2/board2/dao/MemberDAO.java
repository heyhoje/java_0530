package db.day2.board2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day2.board2.vo.MemberVO;

public interface MemberDAO { // Dao, service는 메소드만 추가해주면 됨

	MemberVO getMember(String id);

	void insertMember(@Param("id")String id, @Param("pw")String pw);

	void deleteMember(String id);

	ArrayList<MemberVO> selectMemberList();

}
