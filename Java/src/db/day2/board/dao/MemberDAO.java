package db.day2.board.dao;

import db.day2.board.vo.MemberVO;

public interface MemberDAO { // Dao, service�� �޼ҵ常 �߰����ָ� ��

	MemberVO getMember(String id);

	void insertMember(String id, String pw);

	void deleteMember(String id);

}
