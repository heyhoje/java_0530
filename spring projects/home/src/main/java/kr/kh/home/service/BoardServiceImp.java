package kr.kh.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.home.dao.BoardDAO;
import kr.kh.home.pagination.Criteria;
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

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(); // 넌 모르는앤데 새 크리터리아 구나
		}
		return boardDao.selectBoardList(cri); // 크리를 줄게, 리스트를 모아주거라 다오야
	}

}
