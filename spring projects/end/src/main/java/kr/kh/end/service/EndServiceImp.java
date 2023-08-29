package kr.kh.end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.end.dao.EndDAO;

@Service
public class EndServiceImp implements EndService{
	
	@Autowired
	private EndDAO endDao;

	@Override
	public int count() {
		return endDao.selectCountMember();
	}

}
