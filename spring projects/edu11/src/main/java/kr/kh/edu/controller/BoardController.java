package kr.kh.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.edu.pagination.Criteria;
import kr.kh.edu.service.BoardService;
import kr.kh.edu.vo.BoardVO;

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
		
		
		
		// 화면에 데이터를 전송
		model.addAttribute("list", list);
		model.addAttribute("title", "게시글 조회");
//		cri.setPerPageNum(5);
//		List<BoardDAO> list = boardService.getBoardList(cri);
//		
//		int totalCount = boardService.getBoardTotalCount();
//		
//		PageMaker pm = new PageMaker(3, cri, totalCount);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("pm", pm);
		return "/board/list";
	}
}
