package db.day3.board.service;

import db.day3.board.controller.List;
import db.day3.board.vo.BoardVO;

public interface BoardService {
	

	List<BoardVO> getBoardList();

	boolean updateBoard(BoardVO board);

	boolean deleteBoard(BoardVO board);

	boolean insertBoard(BoardVO board);

}
