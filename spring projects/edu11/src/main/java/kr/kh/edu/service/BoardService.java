package kr.kh.edu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;

public interface BoardService {
	
	// 게시글 리스트
	List<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);
	
	// 게시글 등록 / 첨부파일
	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] fileList);
	
	// 상세 게시글 조회
	BoardVO getBoard(int num);

	List<FileVO> getFileList(int num);

}
