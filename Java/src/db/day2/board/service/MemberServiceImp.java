package db.day2.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.day2.board.dao.MemberDAO;
import db.day2.board.dao.MemberMapper;
import db.day2.board.vo.MemberVO;

public class MemberServiceImp implements MemberService { // ����Ŭ������ ���� implements

	private Connection con;
	private MemberDAO memberDao;
	
	public MemberServiceImp(Connection con) {
		this.con = con;
		memberDao = new MemberMapper(con); // 
	}

	@Override
	public boolean signup(String id, String pw) {
		// ���̵� id�� ȸ�������� �����´�(id�� �⺻Ű = �ߺ�üũ �ؾ���)
		MemberVO member = memberDao.getMember(id);
		// System.out.println(memberCount); // Ȯ�ο�
		// ȸ���� ���� 0�� �ƴϸ�, (���� �ִ� ȸ���̴�) ȸ���� ����� ���ϰ�
		if(member != null) {
			return false;
		}
		// 0�̸� ȸ���� ���
		memberDao.insertMember(id, pw);
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		
		MemberVO member = memberDao.getMember(id);
		
		if(member != null && member.getMe_pw().equals(pw)) { // ���� �Է��� pw�� equals()���ο��д�. ���� ������ ���� ������ �������� ������..
			memberDao.deleteMember(id);
			return true;
		}
		return false;
	} 

}
