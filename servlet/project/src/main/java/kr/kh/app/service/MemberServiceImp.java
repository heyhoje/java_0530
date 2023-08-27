package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.MemberVO;

public class MemberServiceImp implements MemberService{

	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";

	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true의 역할 : 쿼리(insert,update,delete) 실행 후 자동 커밋되게 해줌 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean sign_up(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		// 아이디 중복 확인
		// 아이디가 일치하는 회원 정보를 가져옴
		MemberVO deMember = memberDao.selectMember(member.getMe_id());
		// 회원정보가 있으면 => 아이디 중복
		if(deMember != null) {
			return false;
		}
		memberDao.insertMember(member);
		return true;
}
}
