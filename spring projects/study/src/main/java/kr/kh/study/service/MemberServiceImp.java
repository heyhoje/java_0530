package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	    @Autowired
	    private MemberDAO memberDao;

		@Override
		public boolean signup(MemberVO member) {
			// TODO Auto-generated method stub
			return false;
		}

		
	  
}
