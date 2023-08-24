package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "db/day3/board/config/mybatis-config.xml";

	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true�� ���� : ����(insert,update,delete) ���� �� �ڵ� Ŀ�Եǰ� ���� 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		//���̵� �ߺ� üũ => ���̵�� ��ġ�ϴ� ȸ�� ������ ��ȸ�ؼ� ������  
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());

		//���̵� �ߺ����� ������ ȸ�������� ���� => ��ġ�ϴ� ȸ�� ������ ������ 
		if(dbMember == null) {
			memberDao.insertMember2(member);
			return true;
		}
		return false;
	}

}