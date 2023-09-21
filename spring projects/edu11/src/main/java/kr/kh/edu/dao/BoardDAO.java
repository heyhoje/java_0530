package kr.kh.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;

public interface BoardDAO {
	
	// 게시글 리스트
	List<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectCountBoardList(@Param("cri")Criteria cri);
	
	// 게시글 등록
	boolean insertBoard(@Param("board")BoardVO board);

	void insertFile(@Param("fileVo")FileVO fileVo);

	// 게시글 상세 페이지&첨부파일 가져오기
	BoardVO selectBoard(@Param("num")int num);

	List<FileVO> selectFileList(@Param("num")int num);

}
