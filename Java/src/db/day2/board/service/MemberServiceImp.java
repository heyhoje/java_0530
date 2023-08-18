package db.day2.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.day2.board.dao.MemberDAO;
import db.day2.board.dao.MemberMapper;
import db.day2.board.vo.MemberVO;

public class MemberServiceImp implements MemberService { // 구현클래스로 만듦 implements

	private Connection con;
	private MemberDAO memberDao;
	
	public MemberServiceImp(Connection con) {
		this.con = con;
		memberDao = new MemberMapper(con); // 
	}

	@Override
	public boolean signup(String id, String pw) {
		// 아이디가 id인 회원정보를 가져온다(id는 기본키 = 중복체크 해야함)
		MemberVO member = memberDao.getMember(id);
		// System.out.println(memberCount); // 확인용
		// 회원의 수가 0이 아니면, (원래 있는 회원이니) 회원을 등록을 안하고
		if(member != null) {
			return false;
		}
		// 0이면 회원을 등록
		memberDao.insertMember(id, pw);
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		
		MemberVO member = memberDao.getMember(id);
		
		if(member != null && member.getMe_pw().equals(pw)) { // 내가 입력한 pw를 equals()내부에둔다. 무슨 변수와 무슨 변수로 나뉘던가 뭐였지..
			memberDao.deleteMember(id);
			return true;
		}
		return false;
	} 

}
