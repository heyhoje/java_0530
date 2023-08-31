package kr.kh.home.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.home.vo.BoardVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

}
