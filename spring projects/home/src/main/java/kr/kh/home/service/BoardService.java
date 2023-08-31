package kr.kh.home.service;

import java.util.List;

import kr.kh.home.pagination.Criteria;
import kr.kh.home.vo.BoardVO;
import kr.kh.home.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user);

	List<BoardVO> getBoardList(Criteria cri);

}
