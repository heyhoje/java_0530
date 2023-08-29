package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jakarta.annotation.Resources;
import kr.kh.app.dao.MemberDAO;

public class MemberServiceImp implements MemberService{
	
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "WEB-INF/config/mybatis-config.xml";

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
