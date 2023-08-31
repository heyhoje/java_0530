package kr.kh.home.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.home.pagination.Criteria;
import kr.kh.home.pagination.PageMaker;
import kr.kh.home.service.BoardService;
import kr.kh.home.vo.BoardVO;
import kr.kh.home.vo.MemberVO;

@RequestMapping("/board") //보드컨트롤러는 다 /board로 시작하는 애들 관리
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) { // model은 화면으로 보내주기 위한 클래스
		cri.setPerPageNum(2);
		// 현재 페이지에 맞는 게시글을 가져와야함
		List<BoardVO> list = boardService.getBoardList(cri);
//		int totalCount = boardService.getTotalCount(cri);// 지금은 영향이 없지만, 나중에 검색을 위해 cri 미리 넣어둠
//		
//		PageMaker pm = new PageMaker(3, cri, totalCount);
//		
//		model.addAttribute("pm", pm);
		model.addAttribute("list", list); // 페이지 정보와 리스트 정보를 화면에 보여준다고?		
		return "/board/list"; // url이 /board/list로 인식함
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model) {
		// System.out.println(board); // 데이터가 잘 들어갔는지 콘솔창으로 확인 가능
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(boardService.insertBoard(board, user)) { // 개발자 도구로 작성자를 임의로 바꿀 수 있음, 매개변수 세션 & 세션, 유저 객체가져오기
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/insert", "게시글을 등록하지 못했습니다.");
		}
		// 첨부파일 기능을 위한 사전작업 (외래키 - 게시글의 기본키 필요)
		System.out.println(board);
		
		model.addAttribute("msg", msg);
		return "message";
	}
	
	
}
