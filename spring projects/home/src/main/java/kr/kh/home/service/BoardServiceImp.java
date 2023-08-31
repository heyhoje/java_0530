package kr.kh.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.home.dao.BoardDAO;
import kr.kh.home.vo.BoardVO;
import kr.kh.home.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		// 유저 체크
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		// 게시글 체크
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		return boardDao.insertBoard(board); //작은 다오야 게시글 좀 추가해줘
	}

}
