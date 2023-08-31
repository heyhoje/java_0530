package kr.kh.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.home.service.BoardService;
import kr.kh.home.vo.BoardVO;
import kr.kh.home.vo.MemberVO;

@RequestMapping("/board") //보드컨트롤러는 다 /board로 시작하는 애들 관리
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list() {
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
		if(boardService.insertBoard(board)) { // 개발자 도구로 작성자를 임의로 바꿀 수 있음, 매개변수 세션 & 세션, 유저 객체가져오기
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/insert", "게시글을 등록하지 못했습니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	
}
