package kr.kh.spring.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp<BCryptPasswordEncoder> implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		// 아이디 중복 확인
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		// 가입하려는 아이디가 이미 가입된 경우
		if(dbMember != null) {
			return false;
		}
		// 아이디, 비번 null 체크, 유효성 검사
		// 아이디는 영문으로 시작하고, 6~15자
		String idRegex = "^[a-zA-Z][a-ZA-Z0-9]{5, 14}$";
		// 비번은 영문, 숫자, !@#$%로 이루어지고 6~15자
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6, 15}$";
		
		// 아이디가 유효성에 맞지 않으면
		if(!Pattern.matches(idRegex, member.getMe_id())) {
			return false;
		}
		// 비번 유효성에 맞지 않으면
			if(!Pattern.matches(pwRegex, member.getMe_pw())) {
				return false;
		
				
		// 비번 암호화 - 어디랑 어디였는지 기억안남 BCrypt어쩌구 들어가는 곳임 web.xml은 다른거 했던가 어디지..
		
		// 회원가입
		return true;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		// 가입된 아이디가 아니면
		if(dbMember == null) {
			
		}
		return null;
	}

	@Override
	public int count() {
		return memberDao.selectMember();
	}
}