package kr.kh.edu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.pagination.PageMaker;
import kr.kh.edu.service.BoardService;
import kr.kh.edu.vo.BoardVO;
import kr.kh.edu.vo.FileVO;
import kr.kh.edu.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/list")
	public String list(Model model, Criteria cri) {
		// 게시글 전체를 가져오라고 서비스에게 시킴
		// => (수정)현재 페이지 정보에 맞는 게시글 리스트 가져오라고 시킴
		List<BoardVO> list;
		list = boardService.getBoardList(cri);
		
		// 현재 페이지 정보(검색어, 타입)에 맞는 전체 게시글 수를 가져옴
		int totalCount = boardService.getTotalCount(cri);
		// 페이지네이션 페이지 수
		final int DISPLAY_PAGE_NUM = 5;
		
		PageMaker pm = new PageMaker(DISPLAY_PAGE_NUM, cri, totalCount);
		
		// 화면에 데이터를 전송
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 조회");
		
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	// 게시글 등록
	@GetMapping("/board/insert")
	public String insert(Model model) {
		
		model.addAttribute("title", "게시글 등록");
		return "/board/insert"; //jsp랑 연결! /없으면 타일즈 적용 안됨.
	}
	
	@PostMapping("/board/insert")
	public String insertPost(Model model, BoardVO board, HttpSession session, MultipartFile[] fileList) {// 로그인한 회원정보 가져오기 위해
		// System.out.println("/board/insert : " + board);
		
		MemberVO user = (MemberVO) session.getAttribute("user");
		// System.out.println(user);
		
		boolean res = boardService.insertBoard(board, user, fileList);
		if(res) {
			model.addAttribute("msg", "게시글 등록 성공!");
			model.addAttribute("url", "board/list");
		}else {
		model.addAttribute("msg", "게시글 등록 실패!");
		model.addAttribute("url", "board/insert");
		}
		
		return "/main/message"; 
	}
	
	// 게시글 상세 조회
	@GetMapping("/board/detail/{bo_num}")
	public String detail(Model model, @PathVariable("bo_num")int num) {// 경로상에 있는 변수값을 쓸 떄, @PathVariable
		// System.out.println(num); // 오오~ 오늘은 테스트 나옴ㅋㅋ ㅊㅋㅊㅋ
		// 서비스한테 번호알려줄테니까 일치하는 게시글 가져와 시킴
		BoardVO board = boardService.getBoard(num);
		
		// 번호알려줄테니까 일치하는 첨부파일 가져와!
		List<FileVO> fileList = boardService.getFileList(num);
		
		// 화면에 전달
		model.addAttribute("fileList", fileList);
		model.addAttribute("board", board);
		return "/board/detail";
	}
}
