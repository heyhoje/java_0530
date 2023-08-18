package db.day2.board.dao;

import db.day2.board.vo.MemberVO;

public interface MemberDAO { // Dao, service는 메소드만 추가해주면 됨

	MemberVO getMember(String id);

	void insertMember(String id, String pw);

	void deleteMember(String id);

}
