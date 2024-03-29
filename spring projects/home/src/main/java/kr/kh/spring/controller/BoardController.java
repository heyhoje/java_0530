package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board") // 아래에 /board/like 이렇게 쓰면 안됨. requestMapping했기 떄문
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		//현재 페이지에 맞는 게시글을 가져와야함
		List<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert(Model model, Integer bo_ori_num) {
		// 그냥 insert만 있을때는 뭐였는데?? 등록된걸 보여주기? 글쓰기로 들어가는 링크제공????????????
		// 답글 /board/insert?bo_ori_num=${board.bo_num}
		model.addAttribute("bo_ori_num", bo_ori_num == null ? 0 : bo_ori_num);
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files2) {
		// 새로 추가할 bo_ori_num은 BoardVO에 이미 있음 -> BoardMapper 로 이동 
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user, files2)) {
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/insert", "게시글을 등록하지 못했습니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	@GetMapping("/detail")
	public String detail(Model model, Integer bo_num , Criteria cri, HttpSession session) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		//List<FileVO> fileList = boardService.getFileList(bo_num)
		
		MemberVO user = (MemberVO) session.getAttribute("user"); // 얘 왜있음? 강의에는 없음-_-
		// 해당 게시글을 보고있는 회원의 추천이기 때문에 위 코드로 인해 user정보를 가져옴
		LikeVO like = boardService.getBoardLike(bo_num, user); // user정보가 없으니 세션에서 가져옴
		
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
		model.addAttribute("like", like);
		return "/board/detail";
	}
	@GetMapping("/update")
	public String update(Model model,Integer bo_num, HttpSession session) {
		BoardVO board = boardService.getBoard(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || board == null || !user.getMe_id().equals(board.getBo_me_id())) {
			Message msg = new Message("/board/list", "잘못된 접근입니다.");
			model.addAttribute("msg", msg);
			return "message";
		}
		model.addAttribute("board", board);
		return "/board/update";
	}
	@PostMapping("/update")
	public String updatePost(Model model, BoardVO board, 
			MultipartFile[] files, Integer[] delFiles, HttpSession session) {
		Message msg;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, delFiles,user)) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "게시글을 수정했습니다.");
		}else {
			msg = new Message("/board/update?bo_num="+board.getBo_num(), "게시글을 수정하지 못했습니다."); 
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping("/delete")
	public String delete(Model model, HttpSession session, Integer bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.deleteBoard(bo_num, user)) {
			msg = new Message("/board/list", "게시글을 삭제했습니다.");
		}else {
			msg = new Message("/board/list", "잘못된 접근입니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@ResponseBody // ** ajax 하려면 꼭 해당 어노테이션 추가해줘야함
	@PostMapping("/like")
	public Map<String, Object> ajaxTest(@RequestBody LikeVO likeVo){
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 추천 : 1, 비추천 : -1, 취소 : 0 / 추천과 비추천 모두 하나의 메소드로 처리할 예정 
		int res = boardService.like(likeVo);
		//System.out.println(likeVo);
		BoardVO board = boardService.getBoard(likeVo.getLi_bo_num());
	
		map.put("res", res);
		map.put("board", board);
		return map;
	}
}