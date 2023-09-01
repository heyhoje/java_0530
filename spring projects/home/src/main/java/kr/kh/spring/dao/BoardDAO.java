package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;

public interface BoardDAO {
	/***
	 * @param board : 매게변수를 어떻게 넘겨줘야할지 반드시 들어가야할 정보
	 * @return : 게시글 추가여부 반환
	 */
	boolean insertBoard(@Param("board")BoardVO board);

	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

	void updateBoardViews(@Param("bo_num")Integer bo_num);

	void insertFile(@Param("file")FileVO fileVo);

}