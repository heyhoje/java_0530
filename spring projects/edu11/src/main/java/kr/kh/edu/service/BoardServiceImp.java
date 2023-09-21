package kr.kh.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.dao.BoardDAO;
import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.util.UploadFileUtils;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\"; // 무슨 경로?? 무슨 디드라이브???????
	/** 게시글 리스트 */
	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectCountBoardList(cri);
	}
	
	/** 게시글 등록 / 첨부파일 추가 */
	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] fileList) {
		if(board == null || board.getBo_title() == null || 
			board.getBo_title().trim().length() == 0 || board.getBo_contents() == null) {
		return false;
		}
		// 작성자가 없으면 안되기 때문
		if(user == null) {
			return false;
		}
		// 게시글 작성자를 로그인한 회원 아이디로 수정!!!
		board.setBo_me_id(user.getMe_id());
		// 게시글을 DB에 저장하라고 요청
		boolean res = boardDao.insertBoard(board);
		
		if(!res) {
			return false;
		}
		
		// 첨부파일 등록(예정)
		if(fileList == null||fileList.length == 0) {
			return true;
		}
		for(MultipartFile file : fileList) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			//있으면 첨부파일 업로드
			try {
				// 서버에 업로드 => fileVO 필요!!
				// 원래 파일명
				String fi_ori_name = file.getOriginalFilename();
				// 서버에 업로드 후 업로드된 경로와 uuid가 포함된 파일명
				String fi_name = UploadFileUtils.uploadFile(uploadPath, uploadPath, null);
				
				// 파일 객체
				FileVO fileVo = new FileVO(board.getBo_bt_num(), fi_name, fi_ori_name);
				boardDao.insertFile(fileVo); // 다오야, 첨부파일 정보를 db에 넣어줘
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/** 게시글 상세 조회 */
	@Override
	public BoardVO getBoard(int num) {
		// int니까 예외처리 할것 없이 바로 일 시킴 ㄷㄷ
		return boardDao.selectBoard(num); // getBoard 써도 됨, 그냥 매퍼에서 사용할 태그를 쓰는것뿐
	}

	/** 게시글 상세 첨부파일*/
	@Override
	public List<FileVO> getFileList(int num) {
		// 예외처리x
		return boardDao.selectFileList(num);
	}
}