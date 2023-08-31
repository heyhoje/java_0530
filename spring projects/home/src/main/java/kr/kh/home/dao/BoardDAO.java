package kr.kh.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.home.pagination.Criteria;
import kr.kh.home.vo.BoardVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

}
