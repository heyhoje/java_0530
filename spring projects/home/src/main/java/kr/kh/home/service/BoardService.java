package kr.kh.home.service;

import kr.kh.home.vo.BoardVO;
import kr.kh.home.vo.MemberVO;

public interface BoardService {

	boolean insertBoard(BoardVO board, MemberVO user);

}
